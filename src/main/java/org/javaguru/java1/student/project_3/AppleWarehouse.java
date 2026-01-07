package org.javaguru.java1.student.project_3;

import org.javaguru.java1.student.project_3.service.AppleService;

public class AppleWarehouse {

    static AppleService appleService = new AppleService();

    public static void main(String[] args) {
        appleService.run();
    }

}
