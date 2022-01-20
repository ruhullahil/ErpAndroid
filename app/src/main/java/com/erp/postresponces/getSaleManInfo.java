package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



public class getSaleManInfo {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("data")
    @Expose
    private ArrayList<saleManData> data;
    @SerializedName("type")
    @Expose
    private String type;

    public getSaleManInfo(String success, ArrayList<saleManData> data, String type) {
        this.success = success;
        this.data = data;
        this.type = type;
    }

    public getSaleManInfo() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ArrayList<saleManData> getData() {
        return data;
    }

    public void setData(ArrayList<saleManData> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


