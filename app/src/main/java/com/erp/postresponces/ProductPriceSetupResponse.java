package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductPriceSetupResponse {

    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("product_id")
    @Expose
    private List<String> product_id;
    @SerializedName("sale_group")
    @Expose
    private List<String> sale_group;
    @SerializedName("id")
    private Integer id;

    public ProductPriceSetupResponse(Double price, List<String> product_id, List<String> sale_group, Integer id) {
        this.price = price;
        this.product_id = product_id;
        this.sale_group = sale_group;
        this.id = id;
    }

    public ProductPriceSetupResponse() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<String> product_id) {
        this.product_id = product_id;
    }

    public List<String> getSale_group() {
        return sale_group;
    }

    public void setSale_group(List<String> sale_group) {
        this.sale_group = sale_group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
