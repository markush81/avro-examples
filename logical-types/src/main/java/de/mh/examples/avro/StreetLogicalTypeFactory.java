package de.mh.examples.avro;

import org.apache.avro.LogicalType;
import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;

public class StreetLogicalTypeFactory implements LogicalTypes.LogicalTypeFactory {
    @Override
    public LogicalType fromSchema(Schema schema) {
        return new de.mh.examples.avro.StreetLogicalType();
    }
}
