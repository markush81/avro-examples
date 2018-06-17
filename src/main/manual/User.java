/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package de.mh.examples.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1642815005585553161L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"de.mh.examples.avro\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Full name of User\"},{\"name\":\"email\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"EMail adress of user\",\"default\":null},{\"name\":\"salary\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2},\"doc\":\"Salary of User\",\"default\":\"\\u0000\"},{\"name\":\"address\",\"type\":{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"street\",\"type\":{\"type\":\"string\",\"logicalType\":\"custom-street\"},\"doc\":\"Street format ending with house number\"},{\"name\":\"zipcode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Zip Code\"},{\"name\":\"city\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"City\"}]},\"doc\":\"Address of User\"}],\"includeSchemas\":[{\"name\":\"Address\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<User> ENCODER =
      new BinaryMessageEncoder<User>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<User> DECODER =
      new BinaryMessageDecoder<User>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<User> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<User> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<User>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this User to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a User from a ByteBuffer. */
  public static User fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Full name of User */
  @Deprecated public java.lang.String name;
  /** EMail adress of user */
  @Deprecated public java.lang.String email;
  /** Salary of User */
  @Deprecated public java.math.BigDecimal salary;
  /** Address of User */
  @Deprecated public de.mh.examples.avro.Address address;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public User() {}

  /**
   * All-args constructor.
   * @param name Full name of User
   * @param email EMail adress of user
   * @param salary Salary of User
   * @param address Address of User
   */
  public User(java.lang.String name, java.lang.String email, java.math.BigDecimal salary, de.mh.examples.avro.Address address) {
    this.name = name;
    this.email = email;
    this.salary = salary;
    this.address = address;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return email;
    case 2: return salary;
    case 3: return address;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();
  protected static final org.apache.avro.Conversions.DecimalConversion DECIMAL_CONVERSION = new org.apache.avro.Conversions.DecimalConversion();

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      DECIMAL_CONVERSION,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: email = (java.lang.String)value$; break;
    case 2: salary = (java.math.BigDecimal)value$; break;
    case 3: address = (de.mh.examples.avro.Address)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return Full name of User
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * Full name of User
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return EMail adress of user
   */
  public java.lang.String getEmail() {
    return email;
  }

  /**
   * Sets the value of the 'email' field.
   * EMail adress of user
   * @param value the value to set.
   */
  public void setEmail(java.lang.String value) {
    this.email = value;
  }

  /**
   * Gets the value of the 'salary' field.
   * @return Salary of User
   */
  public java.math.BigDecimal getSalary() {
    return salary;
  }

  /**
   * Sets the value of the 'salary' field.
   * Salary of User
   * @param value the value to set.
   */
  public void setSalary(java.math.BigDecimal value) {
    this.salary = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return Address of User
   */
  public de.mh.examples.avro.Address getAddress() {
    return address;
  }

  /**
   * Sets the value of the 'address' field.
   * Address of User
   * @param value the value to set.
   */
  public void setAddress(de.mh.examples.avro.Address value) {
    this.address = value;
  }

  /**
   * Creates a new User RecordBuilder.
   * @return A new User RecordBuilder
   */
  public static de.mh.examples.avro.User.Builder newBuilder() {
    return new de.mh.examples.avro.User.Builder();
  }

  /**
   * Creates a new User RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new User RecordBuilder
   */
  public static de.mh.examples.avro.User.Builder newBuilder(de.mh.examples.avro.User.Builder other) {
    return new de.mh.examples.avro.User.Builder(other);
  }

  /**
   * Creates a new User RecordBuilder by copying an existing User instance.
   * @param other The existing instance to copy.
   * @return A new User RecordBuilder
   */
  public static de.mh.examples.avro.User.Builder newBuilder(de.mh.examples.avro.User other) {
    return new de.mh.examples.avro.User.Builder(other);
  }

  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    /** Full name of User */
    private java.lang.String name;
    /** EMail adress of user */
    private java.lang.String email;
    /** Salary of User */
    private java.math.BigDecimal salary;
    /** Address of User */
    private de.mh.examples.avro.Address address;
    private de.mh.examples.avro.Address.Builder addressBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(de.mh.examples.avro.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.salary)) {
        this.salary = data().deepCopy(fields()[2].schema(), other.salary);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.address)) {
        this.address = data().deepCopy(fields()[3].schema(), other.address);
        fieldSetFlags()[3] = true;
      }
      if (other.hasAddressBuilder()) {
        this.addressBuilder = de.mh.examples.avro.Address.newBuilder(other.getAddressBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing User instance
     * @param other The existing instance to copy.
     */
    private Builder(de.mh.examples.avro.User other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.email)) {
        this.email = data().deepCopy(fields()[1].schema(), other.email);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.salary)) {
        this.salary = data().deepCopy(fields()[2].schema(), other.salary);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.address)) {
        this.address = data().deepCopy(fields()[3].schema(), other.address);
        fieldSetFlags()[3] = true;
      }
      this.addressBuilder = null;
    }

    /**
      * Gets the value of the 'name' field.
      * Full name of User
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * Full name of User
      * @param value The value of 'name'.
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * Full name of User
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * Full name of User
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * EMail adress of user
      * @return The value.
      */
    public java.lang.String getEmail() {
      return email;
    }

    /**
      * Sets the value of the 'email' field.
      * EMail adress of user
      * @param value The value of 'email'.
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder setEmail(java.lang.String value) {
      validate(fields()[1], value);
      this.email = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * EMail adress of user
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'email' field.
      * EMail adress of user
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder clearEmail() {
      email = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'salary' field.
      * Salary of User
      * @return The value.
      */
    public java.math.BigDecimal getSalary() {
      return salary;
    }

    /**
      * Sets the value of the 'salary' field.
      * Salary of User
      * @param value The value of 'salary'.
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder setSalary(java.math.BigDecimal value) {
      validate(fields()[2], value);
      this.salary = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'salary' field has been set.
      * Salary of User
      * @return True if the 'salary' field has been set, false otherwise.
      */
    public boolean hasSalary() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'salary' field.
      * Salary of User
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder clearSalary() {
      salary = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * Address of User
      * @return The value.
      */
    public de.mh.examples.avro.Address getAddress() {
      return address;
    }

    /**
      * Sets the value of the 'address' field.
      * Address of User
      * @param value The value of 'address'.
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder setAddress(de.mh.examples.avro.Address value) {
      validate(fields()[3], value);
      this.addressBuilder = null;
      this.address = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'address' field has been set.
      * Address of User
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'address' field and creates one if it doesn't exist yet.
     * Address of User
     * @return This builder.
     */
    public de.mh.examples.avro.Address.Builder getAddressBuilder() {
      if (addressBuilder == null) {
        if (hasAddress()) {
          setAddressBuilder(de.mh.examples.avro.Address.newBuilder(address));
        } else {
          setAddressBuilder(de.mh.examples.avro.Address.newBuilder());
        }
      }
      return addressBuilder;
    }

    /**
     * Sets the Builder instance for the 'address' field
     * Address of User
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public de.mh.examples.avro.User.Builder setAddressBuilder(de.mh.examples.avro.Address.Builder value) {
      clearAddress();
      addressBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'address' field has an active Builder instance
     * Address of User
     * @return True if the 'address' field has an active Builder instance
     */
    public boolean hasAddressBuilder() {
      return addressBuilder != null;
    }

    /**
      * Clears the value of the 'address' field.
      * Address of User
      * @return This builder.
      */
    public de.mh.examples.avro.User.Builder clearAddress() {
      address = null;
      addressBuilder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User build() {
      try {
        User record = new User();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0], record.getConversion(0));
        record.email = fieldSetFlags()[1] ? this.email : (java.lang.String) defaultValue(fields()[1], record.getConversion(1));
        record.salary = fieldSetFlags()[2] ? this.salary : (java.math.BigDecimal) defaultValue(fields()[2], record.getConversion(2));
        if (addressBuilder != null) {
          record.address = this.addressBuilder.build();
        } else {
          record.address = fieldSetFlags()[3] ? this.address : (de.mh.examples.avro.Address) defaultValue(fields()[3], record.getConversion(3));
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<User>
    WRITER$ = (org.apache.avro.io.DatumWriter<User>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<User>
    READER$ = (org.apache.avro.io.DatumReader<User>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}