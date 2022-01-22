package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConformationResponse {
    @SerializedName("success")
    @Expose
    private Boolean success;

    public ConformationResponse() {
    }

    public ConformationResponse(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
