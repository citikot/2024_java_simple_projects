package org.javaguru.java1.mentor.project_5_property_insurance_calculator.step_22.insurance;

import java.util.List;

public class Policy {

    private String number;
    private PolicyStatus policyStatus;
    private List<InsuredObject> objects;

    public Policy(String number,
                  PolicyStatus policyStatus,
                  List<InsuredObject> objects) {
        this.number = number;
        this.policyStatus = policyStatus;
        this.objects = objects;
    }

    public String getNumber() {
        return number;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public List<InsuredObject> getObjects() {
        return objects;
    }
}
