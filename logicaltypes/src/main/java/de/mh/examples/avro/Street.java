package de.mh.examples.avro;

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

    @Override
    public String toString() {
        return "Street{" +
                "streetPart='" + streetPart + '\'' +
                ", housenumberPart='" + housenumberPart + '\'' +
                '}';
    }
}
