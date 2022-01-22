package com.erp.postresponces;

public class CreateCustomer {
    private String name;
    private String street;
    private String mobile;

    public CreateCustomer(String name, String street, String mobile) {
        this.name = name;
        this.street = street;
        this.mobile = mobile;
    }

    public CreateCustomer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
