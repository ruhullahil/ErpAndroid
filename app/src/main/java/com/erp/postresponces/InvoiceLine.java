package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoiceLine {
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("total")
    @Expose
    private Double total;

    public InvoiceLine(String product, Double quantity, Double total) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
