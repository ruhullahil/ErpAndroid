package com.erp.postresponces;

import com.erp.extraclass.client_user;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerResponse {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private ArrayList<client_user> data;
    @SerializedName("type")
    @Expose
    private String Type;

    public CustomerResponse(Boolean success, ArrayList<client_user> data, String type) {
        this.success = success;
        this.data = data;
        Type = type;
    }

    public CustomerResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<client_user> getData() {
        return data;
    }

    public void setData(ArrayList<client_user> data) {
        this.data = data;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
