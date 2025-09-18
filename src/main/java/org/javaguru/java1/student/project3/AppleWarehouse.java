package org.javaguru.java1.student.project3;

import org.javaguru.java1.student.project3.repository.AppleRepository;

public class AppleWarehouse {

    static AppleRepository appleRepository = new AppleRepository();

    public static void main(String[] args) {
        System.out.println(appleRepository.getApplesByColor("green"));
    }

}
