package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.ConformationResponse;
import com.erp.postresponces.DeliveryResponce;
import com.erp.postresponces.InvoiceResponce;

public class DeliverysViewModel extends ViewModel {
    private MutableLiveData<DeliveryResponce> mutableLiveData;
    private MutableLiveData<ConformationResponse> conformationResponseMutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getDeliverys(Token);

    }
    public LiveData<DeliveryResponce> getInvoiceData() {
        return mutableLiveData;
    }
    public LiveData<DeliveryResponce> getSigleDelevery(String Token,int id ) {
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getDelivery(Token,id);
        return mutableLiveData;
    }
    public LiveData<ConformationResponse> validateDelivery(String Token, int id ) {
        loginResponse = RepositoryPoints.getInstance();
        conformationResponseMutableLiveData = loginResponse.validateDelivery(Token,id);
        return conformationResponseMutableLiveData;
    }
}
