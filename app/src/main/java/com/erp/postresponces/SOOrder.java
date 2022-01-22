package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SOOrder {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("customer")
    @Expose
    private String customer;

    @SerializedName("total")
    @Expose
    private Double total;

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("order_line")
    @Expose
    private List<SOLine> order_line;

    public SOOrder(String name, String customer, Double total, int id, List<SOLine> order_line) {
        this.name = name;
        this.customer = customer;
        this.total = total;
        this.id = id;
        this.order_line = order_line;
    }

    public SOOrder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SOLine> getOrder_line() {
        return order_line;
    }

    public void setOrder_line(List<SOLine> order_line) {
        this.order_line = order_line;
    }
}
