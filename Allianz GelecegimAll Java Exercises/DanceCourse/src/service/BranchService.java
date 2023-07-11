package service;

import model.Branch;

public class BranchService {

    public Branch createNewBranch(String name) {
        return new Branch(name);
    }

}
