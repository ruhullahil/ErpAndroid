package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StockResponse {
    @SerializedName("product_id")
    @Expose
    private List<String> product_id;
    @SerializedName("location_id")
    @Expose
    private List<String>location_id;
    @SerializedName("quantity")
    @Expose
    private Double quantity;

    public StockResponse(List<String> product_id, List<String> location_id, Double quantity) {
        this.product_id = product_id;
        this.location_id = location_id;
        this.quantity = quantity;
    }

    public StockResponse() {
    }

    public List<String> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<String> product_id) {
        this.product_id = product_id;
    }

    public List<String> getLocation_id() {
        return location_id;
    }

    public void setLocation_id(List<String> location_id) {
        this.location_id = location_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
