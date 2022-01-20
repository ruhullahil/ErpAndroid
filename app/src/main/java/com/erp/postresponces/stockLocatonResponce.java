package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class stockLocatonResponce {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private ArrayList<StockResponse> data;

    @SerializedName("type")
    @Expose
    private String type;

    public stockLocatonResponce(Boolean success, ArrayList<StockResponse> data, String type) {
        this.success = success;
        this.data = data;
        this.type = type;
    }

    public stockLocatonResponce() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<StockResponse> getData() {
        return data;
    }

    public void setData(ArrayList<StockResponse> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
