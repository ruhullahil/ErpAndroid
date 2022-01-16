package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponceClass {
    @SerializedName("uid")
    @Expose
    private int uid;

    @SerializedName("user_name")
    @Expose
    private String UserName;

    @SerializedName("access_token")
    @Expose
    private String AccessToken;

    public LoginResponceClass(int uid, String userName, String accessToken) {
        this.uid = uid;
        UserName = userName;
        AccessToken = accessToken;
    }

    public LoginResponceClass() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
}
