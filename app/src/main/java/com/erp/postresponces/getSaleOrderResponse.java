package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class getSaleOrderResponse {
    @SerializedName("success")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private ArrayList<saleOrderData> data;

    public getSaleOrderResponse(Boolean status, ArrayList<saleOrderData> data) {
        this.status = status;
        this.data = data;


    }

    public getSaleOrderResponse() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<saleOrderData> getData() {
        return data;
    }

    public void setData(ArrayList<saleOrderData> data) {
        this.data = data;
    }
}

