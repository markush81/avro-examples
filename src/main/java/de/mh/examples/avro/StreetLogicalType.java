package de.mh.examples.avro;

import org.apache.avro.LogicalType;

public class StreetLogicalType extends LogicalType {

    public StreetLogicalType() {
        super("custom-street");
    }
}
