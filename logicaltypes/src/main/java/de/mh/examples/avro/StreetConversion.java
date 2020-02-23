package de.mh.examples.avro;

import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

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