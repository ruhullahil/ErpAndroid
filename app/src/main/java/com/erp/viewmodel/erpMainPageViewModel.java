package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.LoginResponceClass;
import com.erp.postresponces.getSaleManInfo;

public class erpMainPageViewModel extends ViewModel {
    private MutableLiveData<getSaleManInfo> mutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getSalesManInfo(Token);

    }
    public LiveData<getSaleManInfo> getSalesManInfo() {
        return mutableLiveData;
    }

}
