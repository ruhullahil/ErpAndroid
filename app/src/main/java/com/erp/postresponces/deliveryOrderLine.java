package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class deliveryOrderLine {
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("quantity")
    @Expose
    private Double quantity;

    public deliveryOrderLine(String product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public deliveryOrderLine() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
