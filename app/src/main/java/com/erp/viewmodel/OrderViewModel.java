package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.CustomerResponse;
import com.erp.postresponces.SaleOrderResponse;

public class OrderViewModel extends ViewModel {
    private MutableLiveData<SaleOrderResponse> mutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getOrders(Token);

    }
    public LiveData<SaleOrderResponse> getCustomerData() {
        return mutableLiveData;
    }
}
