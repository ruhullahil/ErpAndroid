package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DeliveryOrder {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("sale_id")
    @Expose
    private int sale_id;
    @SerializedName("sale_order")
    @Expose
    private String sale_order;
    @SerializedName("customer")
    @Expose
    private String customer;
    @SerializedName("order_line")
    @Expose
    private ArrayList<deliveryOrderLine> order_line;

    public DeliveryOrder(String name, int id, int sale_id, String sale_order, String customer, ArrayList<deliveryOrderLine> order_line) {
        this.name = name;
        this.id = id;
        this.sale_id = sale_id;
        this.sale_order = sale_order;
        this.customer = customer;
        this.order_line = order_line;
    }

    public DeliveryOrder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public String getSale_order() {
        return sale_order;
    }

    public void setSale_order(String sale_order) {
        this.sale_order = sale_order;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<deliveryOrderLine> getOrder_line() {
        return order_line;
    }

    public void setOrder_line(ArrayList<deliveryOrderLine> order_line) {
        this.order_line = order_line;
    }
}
