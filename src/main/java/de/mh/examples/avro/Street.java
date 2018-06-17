package de.mh.examples.avro;

public class Street {

    private String streetName;
    private String houseNumber;

    Street(String streetName, String houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public static Street fromString(String streetString) {
        String[] split = streetString.split(" ");
        return new Street(split[0], split[1]);
    }

    @Override
    public String toString() {
        return streetName + " " + houseNumber;
    }
}
