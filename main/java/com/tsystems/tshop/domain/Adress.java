package com.tsystems.tshop.domain;

public class Adress {
    private String country;
    private Integer postalcode;
    private String city;
    private String house;
    private String flat;
    private String street;

    public Adress(){};

    public Adress(final String country, final Integer postalcode, final String city, final String house, final String flat,
                  final String street){
        super();
        this.country = country;
        this.postalcode = postalcode;
        this.city = city;
        this.house = house;
        this.flat = flat;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
