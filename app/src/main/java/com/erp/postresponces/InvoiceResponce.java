package com.erp.postresponces;

import com.erp.extraclass.client_user;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InvoiceResponce {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private ArrayList<InvoiceOrders> data;
    @SerializedName("type")
    @Expose
    private String Type;

    public InvoiceResponce(Boolean success, ArrayList<InvoiceOrders> data, String type) {
        this.success = success;
        this.data = data;
        Type = type;
    }

    public InvoiceResponce() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<InvoiceOrders> getData() {
        return data;
    }

    public void setData(ArrayList<InvoiceOrders> data) {
        this.data = data;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
