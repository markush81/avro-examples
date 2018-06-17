# Avro Examples

A bunch of avro examples.

:warning: The project will not compile because of Custom LogicalType, i am still working how to solve this problem.

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

:warning: Not working with Avro compiler, since i have no clue how to register custom logicalTypes for compile process

```json
    {
      "name": "street",
      "type": {
        "type": "string",
        "logicalType": "custom-street"
      },
      "doc": "Street format ending with house number"
    }
```

Custom StreetLogicalType

```java
public class StreetLogicalType extends LogicalType {

    public StreetLogicalType() {
        super("custom-street");
    }
}
```

Custom StreetConversion

```java
 public static class StreetConversion extends Conversion<Street> {
        @Override
        public Class<Street> getConvertedType() {
            return Street.class;
        }

        @Override
        public Schema getRecommendedSchema() {
            return LogicalTypes.uuid().addToSchema(Schema.create(Schema.Type.STRING));
        }

        @Override
        public String getLogicalTypeName() {
            return "custom-street";
        }

        @Override
        public Street fromCharSequence(CharSequence value, Schema schema, LogicalType type) {
            return Street.fromString(value.toString());
        }

        @Override
        public CharSequence toCharSequence(Street value, Schema schema, LogicalType type) {
            return value.toString();
        }
    }
```

Register LogicalType before schema parser is initiated first time

```java
LogicalTypes.register("custom-street", schema -> new StreetLogicalType());
```

Manually adapted objects to get it working can be found in `src/main/manual` `Address` and `User`:
- removed `avro.java.string`
- adapted type `String` to `Street`
- added conversion array
