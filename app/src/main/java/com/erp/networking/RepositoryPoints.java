package com.erp.networking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.erp.postresponces.LoginResponceClass;
import com.erp.postresponces.StockResponse;
import com.erp.postresponces.getSaleManInfo;
import com.erp.postresponces.stockLocatonResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryPoints {
    private static RepositoryPoints repositoryPoints;

    public static RepositoryPoints getInstance() {
        if (repositoryPoints == null) {
            repositoryPoints = new RepositoryPoints();
        }
        return repositoryPoints;
    }

    private RetrofitEndPoin retrofitEndPoin;

    public RepositoryPoints() {
        retrofitEndPoin = RetrofitService.cteateService(RetrofitEndPoin.class);

    }


    public MutableLiveData<LoginResponceClass> getRepositoryPoints(String login, String password, String db) {
        MutableLiveData<LoginResponceClass> loginData = new MutableLiveData<>();
        Log.d("_____False :", "come here ---1");
        retrofitEndPoin.getToken(login, password, db).enqueue(new Callback<LoginResponceClass>() {
            @Override
            public void onResponse(Call<LoginResponceClass> call, Response<LoginResponceClass> response) {
                Log.d("_____False :", "come here 2");
                if (response.isSuccessful()) {
                    loginData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<LoginResponceClass> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                loginData.setValue(null);

            }
        });
        return loginData;
    }

    public MutableLiveData<getSaleManInfo> getSalesManInfo(String Token) {
        MutableLiveData<getSaleManInfo> salesManInfoData = new MutableLiveData<>();
        Log.d("_____False :", "come here ---1");
        retrofitEndPoin.getSalesManInfo(Token).enqueue(new Callback<getSaleManInfo>() {
            @Override
            public void onResponse(Call<getSaleManInfo> call, Response<getSaleManInfo> response) {
                if (response.isSuccessful()) {
                    salesManInfoData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<getSaleManInfo> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                salesManInfoData.setValue(null);

            }
        });
        return salesManInfoData;

    }

    public MutableLiveData<stockLocatonResponce> getStockData(String Token, int location) {
        MutableLiveData<stockLocatonResponce> stockData = new MutableLiveData<>();
        Log.d("_____False :", "come here "+location);
        retrofitEndPoin.getLocationStock(Token, location).enqueue(new Callback<stockLocatonResponce>() {
            @Override
            public void onResponse(Call<stockLocatonResponce> call, Response<stockLocatonResponce> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    stockData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<stockLocatonResponce> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                stockData.setValue(null);

            }
        });
        return stockData;

    }

}
