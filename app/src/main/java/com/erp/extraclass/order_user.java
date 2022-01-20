package com.erp.extraclass;

public class order_user {
    String customer_name, address, total_price;

    public order_user(String customer_name, String address, String total_price) {
        this.customer_name = customer_name;
        this.address = address;
        this.total_price = total_price;

    }
    public String getCustomer_name() {
        return customer_name;
    }

    public String getAddress() {
        return address;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
}
