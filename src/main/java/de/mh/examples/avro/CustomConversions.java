package de.mh.examples.avro;

import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;

public class CustomConversions {

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
}
