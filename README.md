# Avro Examples

An Avro example which makes use of builtin logicalType as well as adds a custom logicalType.

## Run the examples

```bash
# Create logicalType package first

cd logicaltypes
./gradlew build

# Next you can run the example project
cd ../example
./gradlew build
```

Reason behind is, that the Gradle plugin generating Java code from Avro schema needs the LogicalType, its factory and Conversion to generate the right types.

## Optional Field

```json
{
  "name": "email",
  "type": [
    "null",
    "string"
  ],
  "default": null,
  "doc": "EMail adress of user"
}
```

## Built-In LogicalType decimal with default value 0

```json
{
  "name": "salary",
  "type": {
    "type": "bytes",
    "logicalType": "decimal",
    "precision": 10,
    "scale": 2
  },
  "default": "\u0000",
  "doc": "Salary of User"
}
```

Needs specific configuration of the Avro compiler

```groovy
avro {
    enableDecimalLogicalType = true
}
```

## Custom LogicalType

```json
    {
      "name": "street",
      "type": {
        "type": "string",
        "logicalType": "street"
      },
      "doc": "Street format ending with house number"
    }
```

### Street Object

```java
public class Street {

    private String streetPart;
    private String housenumberPart;

    public Street(String streetPart, String housenumberPart) {
        this.streetPart = streetPart;
        this.housenumberPart = housenumberPart;
    }

    public Street(String[] split) {
        streetPart = split[0];
        housenumberPart = split[1];
    }

    public String getStreetPart() {
        return streetPart;
    }

    public String getHousenumberPart() {
        return housenumberPart;
    }

    public String serialize() {
        return String.format("%s|%s",streetPart,housenumberPart);
    }

    public static Street deserialize(String street) {
        return new Street(street.split("|"));
    }
}
```


### Custom StreetLogicalType

```java
public class StreetLogicalType extends LogicalType {

    StreetLogicalType() {
        super("street");
    }

    @Override
    public void validate(Schema schema) {
        super.validate(schema);
        if (schema.getType() != Schema.Type.STRING) {
            throw new IllegalArgumentException("Street can only be used with an underlying string type");
        }
    }
}
```

### StreetLogicalTypeFactory

```java
public class StreetLogicalTypeFactory implements LogicalTypes.LogicalTypeFactory {
    @Override
    public LogicalType fromSchema(Schema schema) {
        return new de.mh.examples.avro.StreetLogicalType();
    }
}
```

### Custom StreetConversion

```java
public class StreetConversion extends Conversion<Street> {

    @Override
    public Class<Street> getConvertedType() {
        return Street.class;
    }

    @Override
    public String getLogicalTypeName() {
        return "street";
    }

    @Override
    public Street fromCharSequence(CharSequence value, Schema schema, LogicalType type) {
        return Street.deserialize(value.toString());
    }

    @Override
    public CharSequence toCharSequence(Street value, Schema schema, LogicalType type) {
        return value.serialize();
    }
}
```

### Gradle Plugin configuration


```groovy
plugins {
    id 'com.commercehub.gradle.plugin.avro' version '0.18.0'
}

dependencies {
    implementation 'org.apache.avro:avro:1.9.2'
}

avro {
    enableDecimalLogicalType = true
    dateTimeLogicalType = "JSR310"
    stringType = "String"
    outputCharacterEncoding = "UTF-8"
    logicalTypeFactory("street", de.mh.examples.avro.StreetLogicalTypeFactory)
    customConversion(de.mh.examples.avro.StreetConversion)
}
```

### Register LogicalType before schema parser is instantiated

```java
LogicalTypes.register("street", new StreetLogicalTypeFactory());
```

