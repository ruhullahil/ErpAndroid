package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StockResponse {
    @SerializedName("product_id")
    @Expose
    private int product_id;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("product")
    @Expose
    private String product;

    public StockResponse(int product_id, String location, Double quantity, String product) {
        this.product_id = product_id;
        this.location = location;
        this.quantity = quantity;
        this.product = product;
    }

    public StockResponse() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
