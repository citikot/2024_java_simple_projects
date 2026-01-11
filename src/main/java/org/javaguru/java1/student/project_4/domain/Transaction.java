package org.javaguru.java1.student.project_4.domain;

public record Transaction(Trader trader, int year, int value) {

    public String toString() {
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}
