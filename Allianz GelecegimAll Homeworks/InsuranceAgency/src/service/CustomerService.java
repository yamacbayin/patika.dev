package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);

        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccountList() != null) {
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);
            customer.setBankAccountList(bankAccountList);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() != null) {
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequestList = new ArrayList<>();
            insuranceRequestList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestList);
        }
    }

    public void addPolicyListToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() != null) {
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policyRequestList = new ArrayList<>();
            policyRequestList.add(policy);
            customer.setPolicyList(policyRequestList);
        }
    }

    public void addPaymentMovementCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() != null) {
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementList);
        }
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() != null) {
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicleList = new ArrayList<>();
            vehicleList.add(vehicle);
            customer.setVehicleList(vehicleList);
        }
    }


    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest) {
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();
        for (InsuranceRequest insuranceRequest1 : insuranceRequestList) {
            if (insuranceRequest1.equals(insuranceRequest)) {
                for (Proposal proposal1 : insuranceRequest1.getProposalList()) {
                    if (proposal1.equals(proposal)) {
                        BankAccount bankAccount = checkBankAccount(customer, proposalService.calculateDiscountedPrice(proposal));
                        if (bankAccount != null) {
                            bankAccount.setAmount(bankAccount.getAmount().subtract(proposalService.calculateDiscountedPrice(proposal)));

                        }
                        proposal1.setApproved(true);
                    }
                }
            }
        }
    }

    public BankAccount checkBankAccount(Customer customer, BigDecimal amount) {
        List<BankAccount> bankAccountList = customer.getBankAccountList();
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }

    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest, Agency agency) {
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();
        for (InsuranceRequest request : insuranceRequestList) {
            if (request.equals(insuranceRequest)) {
                Proposal matchingProposal = insuranceRequest.getProposalList().stream()
                        .filter(p -> p.equals(proposal))
                        .findFirst()
                        .orElse(null);

                if (matchingProposal != null) {
                    BigDecimal discountedPrice = proposalService.calculateDiscountedPrice(proposal);
                    BigDecimal commissionAmount = discountedPrice.multiply(proposal.getCompany().getCommission().divide(new BigDecimal(100)));
                    BankAccount customerBankAccount = checkCustomerBankAccount(customer, discountedPrice);
                    BankAccount companyBankAccount = proposal.getCompany().getBankAccountList().get(0);
                    BankAccount agencyBankAccount = agency.getBankAccountList().get(0);

                    if (customerBankAccount != null && proposal.getCompany().getBankAccountList() != null && agency.getBankAccountList() != null) {
                        bankAccountService.makePayment(companyBankAccount, customerBankAccount, discountedPrice);
                        PaymentMovement customerPaymentMovement = paymentMovementService.createPaymentMovement(customerBankAccount, "Traffic Insurance Payment", MovementType.OUTCOME, discountedPrice);
                        addPaymentMovementToCustomer(customer, customerPaymentMovement);
                        PaymentMovement companyPaymentMovement = paymentMovementService.createPaymentMovement(companyBankAccount, "Insurance income", MovementType.INCOME, discountedPrice);
                        companyService.addPaymentMovementToInsuranceCompany(proposal.getCompany(), companyPaymentMovement);
                        bankAccountService.makePayment(agencyBankAccount, companyBankAccount, commissionAmount);
                        PaymentMovement agencyPaymentMovement = paymentMovementService.createPaymentMovement(agencyBankAccount, "Commission income", MovementType.INCOME, commissionAmount);
                        agencyService.addPaymentMovementToAgency(agency, agencyPaymentMovement);
                        PaymentMovement companyPaymentMovement2 = paymentMovementService.createPaymentMovement(companyBankAccount, "Commission Outcome", MovementType.OUTCOME, commissionAmount);
                        companyService.addPaymentMovementToInsuranceCompany(proposal.getCompany(), companyPaymentMovement2);

                        Policy policy = policyService.createPolicy(proposal.getCompany(), proposal.getVehicle(), discountedPrice, proposal.getStartDate(), proposal.getEndDate());
                        addPolicyToCustomer(customer, policy);

                        matchingProposal.setApproved(true);

                        System.out.println(proposal.getVehicle().getPlate() + " için " + proposal.getCompany().getName() + " şirketinden " + discountedPrice + " TL karşılığında poliçe alındı.");
                        System.out.println("Poliçe başlangıç tarihi: " + proposal.getStartDate());
                        System.out.println("Poliçe bitiş tarihi: " + proposal.getEndDate());
                        System.out.println("Poliçe sahibi: " + customer.getName());
                        System.out.println("Poliçe komisyon oranı: " + proposal.getCompany().getCommission());
                        System.out.println("Poliçe komisyon ödemesi: " + commissionAmount);
                    }
                }
            }
        }
    }

    public BankAccount checkCustomerBankAccount(Customer customer, BigDecimal amount) {
        List<BankAccount> bankAccountList = customer.getBankAccountList();
        for (BankAccount account : bankAccountList) {
            if (account.getAmount().compareTo(amount) >= 0) {
                return account;
            }
        }
        return null;
    }
}
