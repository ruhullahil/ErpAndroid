package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.ConformationResponse;
import com.erp.postresponces.CreateCustomer;
import com.erp.postresponces.SaleOrderResponse;

public class createCustomerViewModel extends ViewModel {
    private MutableLiveData<ConformationResponse> mutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token , CreateCustomer customer){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.createCustomer(Token,customer);

    }
    public LiveData<ConformationResponse> createCustomer() {
        return mutableLiveData;
    }
}
