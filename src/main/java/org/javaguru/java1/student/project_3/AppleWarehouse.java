package org.javaguru.java1.student.project_3;

import org.javaguru.java1.student.project_3.repository.AppleRepository;

@SuppressWarnings("java:S106")
public class AppleWarehouse {

    static AppleRepository appleRepository = new AppleRepository();

    public static void main(String[] args) {
        System.out.println(appleRepository.getApplesByColor("green"));
    }

}
