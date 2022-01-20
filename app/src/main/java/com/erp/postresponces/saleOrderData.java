package com.erp.postresponces;

import java.util.ArrayList;

public class saleOrderData {
    private String name;
    private float id;
    private String customer;
    private float total;
    ArrayList< saleOrderLIne > order_line = new ArrayList < saleOrderLIne > ();

    public saleOrderData(String name, float id, String customer, float total, ArrayList<saleOrderLIne> order_line) {
        this.name = name;
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.order_line = order_line;
    }

    public saleOrderData() {
    }
// Getter Methods

    public ArrayList<saleOrderLIne> getOrder_line() {
        return order_line;
    }

    public void setOrder_line(ArrayList<saleOrderLIne> order_line) {
        this.order_line = order_line;
    }

    public String getName() {
        return name;
    }

    public float getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public float getTotal() {
        return total;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
