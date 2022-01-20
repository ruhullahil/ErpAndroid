package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.StockResponse;
import com.erp.postresponces.getSaleManInfo;
import com.erp.postresponces.stockLocatonResponce;

public class locationStockViewModel extends ViewModel {
    private MutableLiveData<stockLocatonResponce> mutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token,int location){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getStockData(Token,location);

    }
    public LiveData<stockLocatonResponce> getStockData() {
        return mutableLiveData;
    }
}
