package org.javaguru.java1.mentor.project_8_bank_transactions.step_35.banktransactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Transaction}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTransaction.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableTransaction.of()}.
 */
@Generated(from = "Transaction", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
final class ImmutableTransaction
    implements Transaction {
  private final int amount;
  private final TransactionType transactionType;

  private ImmutableTransaction(
      int amount,
      TransactionType transactionType) {
    this.amount = amount;
    this.transactionType = Objects.requireNonNull(transactionType, "transactionType");
  }

  private ImmutableTransaction(
      ImmutableTransaction original,
      int amount,
      TransactionType transactionType) {
    this.amount = amount;
    this.transactionType = transactionType;
  }

  /**
   * @return The value of the {@code amount} attribute
   */
  @Override
  public int amount() {
    return amount;
  }

  /**
   * @return The value of the {@code transactionType} attribute
   */
  @Override
  public TransactionType transactionType() {
    return transactionType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Transaction#amount() amount} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for amount
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTransaction withAmount(int value) {
    if (this.amount == value) return this;
    return new ImmutableTransaction(this, value, this.transactionType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Transaction#transactionType() transactionType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for transactionType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTransaction withTransactionType(TransactionType value) {
    TransactionType newValue = Objects.requireNonNull(value, "transactionType");
    if (this.transactionType == newValue) return this;
    return new ImmutableTransaction(this, this.amount, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTransaction} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTransaction
        && equalTo(0, (ImmutableTransaction) another);
  }

  private boolean equalTo(int synthetic, ImmutableTransaction another) {
    return amount == another.amount
        && transactionType.equals(another.transactionType);
  }

  /**
   * Computes a hash code from attributes: {@code amount}, {@code transactionType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + amount;
    h += (h << 5) + transactionType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Transaction} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Transaction{"
        + "amount=" + amount
        + ", transactionType=" + transactionType
        + "}";
  }

  /**
   * Construct a new immutable {@code Transaction} instance.
   * @param amount The value for the {@code amount} attribute
   * @param transactionType The value for the {@code transactionType} attribute
   * @return An immutable Transaction instance
   */
  public static ImmutableTransaction of(int amount, TransactionType transactionType) {
    return new ImmutableTransaction(amount, transactionType);
  }

  /**
   * Creates an immutable copy of a {@link Transaction} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Transaction instance
   */
  public static ImmutableTransaction copyOf(Transaction instance) {
    if (instance instanceof ImmutableTransaction) {
      return (ImmutableTransaction) instance;
    }
    return ImmutableTransaction.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTransaction ImmutableTransaction}.
   * <pre>
   * ImmutableTransaction.builder()
   *    .amount(int) // required {@link Transaction#amount() amount}
   *    .transactionType(org.javaguru.java1.mentor.project_8_bank_transactions.step_35.banktransactions.TransactionType) // required {@link Transaction#transactionType() transactionType}
   *    .build();
   * </pre>
   * @return A new ImmutableTransaction builder
   */
  public static ImmutableTransaction.Builder builder() {
    return new ImmutableTransaction.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTransaction ImmutableTransaction}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Transaction", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_AMOUNT = 0x1L;
    private static final long INIT_BIT_TRANSACTION_TYPE = 0x2L;
    private long initBits = 0x3L;

    private int amount;
    private TransactionType transactionType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Transaction} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Transaction instance) {
      Objects.requireNonNull(instance, "instance");
      amount(instance.amount());
      transactionType(instance.transactionType());
      return this;
    }

    /**
     * Initializes the value for the {@link Transaction#amount() amount} attribute.
     * @param amount The value for amount 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder amount(int amount) {
      this.amount = amount;
      initBits &= ~INIT_BIT_AMOUNT;
      return this;
    }

    /**
     * Initializes the value for the {@link Transaction#transactionType() transactionType} attribute.
     * @param transactionType The value for transactionType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder transactionType(TransactionType transactionType) {
      this.transactionType = Objects.requireNonNull(transactionType, "transactionType");
      initBits &= ~INIT_BIT_TRANSACTION_TYPE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTransaction ImmutableTransaction}.
     * @return An immutable instance of Transaction
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTransaction build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTransaction(null, amount, transactionType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_AMOUNT) != 0) attributes.add("amount");
      if ((initBits & INIT_BIT_TRANSACTION_TYPE) != 0) attributes.add("transactionType");
      return "Cannot build Transaction, some of required attributes are not set " + attributes;
    }
  }
}
