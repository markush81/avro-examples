package de.mh.examples.avro;

import org.apache.avro.LogicalTypes;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class AvroExamples {

    private static final Logger LOGGER = LoggerFactory.getLogger(AvroExamples.class);

    public static void main(String[] args) throws IOException {
        LogicalTypes.register("custom-street", schema -> new StreetLogicalType());

        User user1 = User.newBuilder()
                .setName("Jane Doe")
                .setEmail("mail@domain.org")
                .setAddress(Address.newBuilder()
                        .setCity("Buxtehude")
                        .setStreet(new Street("Anyhwere", "5"))
                        .setZipcode("75869")
                        .build())
                .build();

        User user2 = User.newBuilder()
                .setName("Jon Doe")
                .setSalary(BigDecimal.valueOf(90000.00).setScale(2))
                .setAddress(Address.newBuilder()
                        .setCity("Buxtehude")
                        .setStreet(new Street("Anyhwere", "10"))
                        .setZipcode("75869")
                        .build())
                .build();

        File file = File.createTempFile("user", "avro");


        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<>(User.class);
        try (DataFileWriter<User> dataFileWriter = new DataFileWriter<>(userDatumWriter)) {
            dataFileWriter.create(user1.getSchema(), file);
            dataFileWriter.append(user1);
            dataFileWriter.append(user2);
        }

        // Deserialize Users from disk
        DatumReader<User> userDatumReader = new SpecificDatumReader<>(User.class);
        try (DataFileReader<User> dataFileReader = new DataFileReader<>(file, userDatumReader)) {
            while (dataFileReader.hasNext()) {
                LOGGER.info("{}", dataFileReader.next());
            }
        }
    }
}
