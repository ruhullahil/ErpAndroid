package com.erp.postresponces;

public class saleOrderLIne {


    private String product;
    private float quantity;
    private float total;


    // Getter Methods

    public String getProduct() {
        return product;
    }

    public float getQuantity() {
        return quantity;
    }

    public float getTotal() {
        return total;
    }

    // Setter Methods

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}