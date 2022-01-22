package com.erp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erp.networking.RepositoryPoints;
import com.erp.postresponces.CustomerResponse;
import com.erp.postresponces.InvoiceResponce;

public class invoicesViewModel extends ViewModel {
    private MutableLiveData<InvoiceResponce> mutableLiveData;
    private RepositoryPoints loginResponse;
    public void init(String Token){
        if (mutableLiveData != null){
            return;
        }
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getInvoices(Token);

    }
    public LiveData<InvoiceResponce> getInvoiceData() {
        return mutableLiveData;
    }
    public LiveData<InvoiceResponce> getsSingleInvoiceData(String Token ,int id ) {
        loginResponse = RepositoryPoints.getInstance();
        mutableLiveData = loginResponse.getInvoice(Token,id);
        return mutableLiveData;
    }
}
