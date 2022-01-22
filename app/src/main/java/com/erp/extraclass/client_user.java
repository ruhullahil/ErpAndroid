package com.erp.extraclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class client_user {
    @SerializedName("name")
    @Expose
    private String client_name;

    @SerializedName("address")
    @Expose
    private String shop_address;

    @SerializedName("phone_number")
    @Expose
    private String client_contact;

    @SerializedName("customer_dept")
    @Expose
    private String client_dept;

    public client_user(String client_name, String shop_address, String client_contact) {
        this.client_name = client_name;
        this.shop_address = shop_address;
        this.client_contact = client_contact;
    }

    public client_user(String client_name, String shop_address, String client_contact, String client_dept) {
        this.client_name = client_name;
        this.shop_address = shop_address;
        this.client_contact = client_contact;
        this.client_dept = client_dept;
    }


    public String getClient_dept() {
        return client_dept;
    }

    public void setClient_dept(String client_dept) {
        this.client_dept = client_dept;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public void setClient_contact(String client_contact) {
        this.client_contact = client_contact;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public String getClient_contact() {
        return client_contact;
    }
}
