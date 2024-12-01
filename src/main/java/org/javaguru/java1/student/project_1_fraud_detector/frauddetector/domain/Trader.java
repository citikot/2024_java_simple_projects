package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record Trader(String fullName, String city, String country) {}
