package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DeliveryResponce {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private ArrayList<DeliveryOrder> data;
    @SerializedName("type")
    @Expose
    private String Type;

    public DeliveryResponce(Boolean success, ArrayList<DeliveryOrder> data, String type) {
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

    public ArrayList<DeliveryOrder> getData() {
        return data;
    }

    public void setData(ArrayList<DeliveryOrder> data) {
        this.data = data;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
