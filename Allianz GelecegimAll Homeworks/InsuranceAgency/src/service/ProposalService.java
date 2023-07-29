package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {

    public Proposal createProposal(InsuranceCompany company, Vehicle vehicle, BigDecimal offerPrice,
                                   LocalDate startDate, LocalDate endDate, LocalDate expireDate,
                                   BigDecimal discountPrice) {
        Proposal proposal = new Proposal();
        proposal.setCompany(company);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setDiscountPrice(discountPrice);

        return proposal;
    }

    public BigDecimal calculateDiscountedPrice(Proposal proposal) {
        if (proposal.getDiscountPrice()!= null){
            return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
        } else {
            return proposal.getOfferPrice();
        }
    }

}
