package org.javaguru.java1.student.project_1_fraud_detector.frauddetector.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
record Transaction(Trader trader, int amount) {}

