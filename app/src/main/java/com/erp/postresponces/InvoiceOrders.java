package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InvoiceOrders {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("customer")
    @Expose
    private String customer;
    @SerializedName("sale_order")
    @Expose
    private String sale_order;
    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("order_line")
    @Expose
    private ArrayList<InvoiceLine> order_line;

    public InvoiceOrders() {
    }

    public InvoiceOrders(String name, int id, String customer, String sale_order, Double total, ArrayList<InvoiceLine> order_line) {
        this.name = name;
        this.id = id;
        this.customer = customer;
        this.sale_order = sale_order;
        this.total = total;
        this.order_line = order_line;
    }

    public String getSale_order() {
        return sale_order;
    }

    public void setSale_order(String sale_order) {
        this.sale_order = sale_order;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<InvoiceLine> getOrder_line() {
        return order_line;
    }

    public void setOrder_line(ArrayList<InvoiceLine> order_line) {
        this.order_line = order_line;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
