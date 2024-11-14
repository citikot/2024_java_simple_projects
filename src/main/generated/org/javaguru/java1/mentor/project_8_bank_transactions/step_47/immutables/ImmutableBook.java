package org.javaguru.java1.mentor.project_8_bank_transactions.step_47.immutables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Book}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableBook.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableBook.of()}.
 */
@Generated(from = "Book", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
final class ImmutableBook
    implements Book {
  private final String authorFullName;
  private final String title;

  private ImmutableBook(String authorFullName, String title) {
    this.authorFullName = Objects.requireNonNull(authorFullName, "authorFullName");
    this.title = Objects.requireNonNull(title, "title");
  }

  private ImmutableBook(ImmutableBook original, String authorFullName, String title) {
    this.authorFullName = authorFullName;
    this.title = title;
  }

  /**
   * @return The value of the {@code authorFullName} attribute
   */
  @Override
  public String authorFullName() {
    return authorFullName;
  }

  /**
   * @return The value of the {@code title} attribute
   */
  @Override
  public String title() {
    return title;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Book#authorFullName() authorFullName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for authorFullName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBook withAuthorFullName(String value) {
    String newValue = Objects.requireNonNull(value, "authorFullName");
    if (this.authorFullName.equals(newValue)) return this;
    return new ImmutableBook(this, newValue, this.title);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Book#title() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBook withTitle(String value) {
    String newValue = Objects.requireNonNull(value, "title");
    if (this.title.equals(newValue)) return this;
    return new ImmutableBook(this, this.authorFullName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableBook} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableBook
        && equalTo(0, (ImmutableBook) another);
  }

  private boolean equalTo(int synthetic, ImmutableBook another) {
    return authorFullName.equals(another.authorFullName)
        && title.equals(another.title);
  }

  /**
   * Computes a hash code from attributes: {@code authorFullName}, {@code title}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + authorFullName.hashCode();
    h += (h << 5) + title.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Book} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Book{"
        + "authorFullName=" + authorFullName
        + ", title=" + title
        + "}";
  }

  /**
   * Construct a new immutable {@code Book} instance.
   * @param authorFullName The value for the {@code authorFullName} attribute
   * @param title The value for the {@code title} attribute
   * @return An immutable Book instance
   */
  public static ImmutableBook of(String authorFullName, String title) {
    return new ImmutableBook(authorFullName, title);
  }

  /**
   * Creates an immutable copy of a {@link Book} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Book instance
   */
  public static ImmutableBook copyOf(Book instance) {
    if (instance instanceof ImmutableBook) {
      return (ImmutableBook) instance;
    }
    return ImmutableBook.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableBook ImmutableBook}.
   * <pre>
   * ImmutableBook.builder()
   *    .authorFullName(String) // required {@link Book#authorFullName() authorFullName}
   *    .title(String) // required {@link Book#title() title}
   *    .build();
   * </pre>
   * @return A new ImmutableBook builder
   */
  public static ImmutableBook.Builder builder() {
    return new ImmutableBook.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableBook ImmutableBook}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Book", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_AUTHOR_FULL_NAME = 0x1L;
    private static final long INIT_BIT_TITLE = 0x2L;
    private long initBits = 0x3L;

    private String authorFullName;
    private String title;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Book} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Book instance) {
      Objects.requireNonNull(instance, "instance");
      authorFullName(instance.authorFullName());
      title(instance.title());
      return this;
    }

    /**
     * Initializes the value for the {@link Book#authorFullName() authorFullName} attribute.
     * @param authorFullName The value for authorFullName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authorFullName(String authorFullName) {
      this.authorFullName = Objects.requireNonNull(authorFullName, "authorFullName");
      initBits &= ~INIT_BIT_AUTHOR_FULL_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Book#title() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableBook ImmutableBook}.
     * @return An immutable instance of Book
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableBook build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableBook(null, authorFullName, title);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_AUTHOR_FULL_NAME) != 0) attributes.add("authorFullName");
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      return "Cannot build Book, some of required attributes are not set " + attributes;
    }
  }
}
