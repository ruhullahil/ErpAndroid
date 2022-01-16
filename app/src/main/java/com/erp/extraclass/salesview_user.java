package com.erp.extraclass;

public class salesview_user {

    String sale_product, salas_quantity, sales_total;

    public salesview_user(String sale_product, String salas_quantity,String sales_total) {
        this.sale_product = sale_product;
        this.salas_quantity = salas_quantity;
        this.sales_total = sales_total;

    }



    public void setSale_product(String sale_product) {
        this.sale_product = sale_product;
    }

    public void setSalas_quantity(String salas_quantity) {
        this.salas_quantity = salas_quantity;
    }

    public void setSales_total(String sales_total) {
        this.sales_total = sales_total;
    }

    public String getSale_product() {
        return sale_product;
    }

    public String getSalas_quantity() {
        return salas_quantity;
    }

    public String getSales_total() {
        return sales_total;
    }
}