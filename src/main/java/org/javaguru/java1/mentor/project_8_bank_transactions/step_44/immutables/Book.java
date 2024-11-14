package org.javaguru.java1.mentor.project_8_bank_transactions.step_44.immutables;

import org.immutables.value.Value;

@Value.Immutable
interface Book {

    @Value.Parameter
    String authorFullName();

    @Value.Parameter
    String title();

}
