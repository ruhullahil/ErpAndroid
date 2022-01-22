package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SaleOrderResponse {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private ArrayList<SOOrder> data;
    @SerializedName("type")
    @Expose
    private String Type;

    public SaleOrderResponse(Boolean success, ArrayList<SOOrder> data, String type) {
        this.success = success;
        this.data = data;
        Type = type;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<SOOrder> getData() {
        return data;
    }

    public void setData(ArrayList<SOOrder> data) {
        this.data = data;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public SaleOrderResponse() {
    }
}
