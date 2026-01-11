package org.javaguru.java1.student.project_4.domain;

public record Trader(String name, String city) {

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
