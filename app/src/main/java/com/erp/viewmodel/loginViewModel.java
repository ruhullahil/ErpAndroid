package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.LoginResponceClass;

public class loginViewModel extends ViewModel {
    private String login,password,db;
    private MutableLiveData<LoginResponceClass> mutableLiveData;
    private RepositoryPoints loginResponse;

    public void init(String Login,String Password,String db){
        if (mutableLiveData != null){
            return;
        }
        this.login = Login;
        this.password = Password;
        this.db = db;
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getRepositoryPoints(this.login,this.password,this.db);

    }

    public LiveData<LoginResponceClass> getNewsRepository() {
        return mutableLiveData;
    }
}
