package com.erp.extraclass;

public class client_user {
    String client_name, shop_address, client_contact;

    public client_user(String client_name, String shop_address, String client_contact) {
        this.client_name = client_name;
        this.shop_address = shop_address;
        this.client_contact = client_contact;
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
