package ru.job4j.streamapi;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String cityName, String streetName, int bldngNo, int apprtNo) {
        city = cityName;
        street = streetName;
        home = bldngNo;
        apartment = apprtNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        if (home != address.home) {
            return false;
        }
        if (apartment != address.apartment) {
            return false;
        }
        if (!city.equals(address.city)) {
            return false;
        }
        return street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return (
                city
                        + street
                        + Integer.toString(home)
                        + Integer.toString(apartment)
        ).hashCode();
    }
}
