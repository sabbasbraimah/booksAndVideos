package domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address
{
    private String houseNumber;
    private String street;
    private String city;
    private String postCode;

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
