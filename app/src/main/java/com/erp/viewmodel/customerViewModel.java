package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.CustomerResponse;
import com.erp.postresponces.stockLocatonResponce;

public class customerViewModel extends ViewModel {
    private MutableLiveData<CustomerResponse> mutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getCustomer(Token);

    }
    public LiveData<CustomerResponse> getCustomerData() {
        return mutableLiveData;
    }
}
