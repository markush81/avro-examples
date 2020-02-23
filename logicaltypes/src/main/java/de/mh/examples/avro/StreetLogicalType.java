package de.mh.examples.avro;

import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

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
