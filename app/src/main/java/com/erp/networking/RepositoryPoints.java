package com.erp.networking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.erp.postresponces.ConformationResponse;
import com.erp.postresponces.CreateCustomer;
import com.erp.postresponces.CustomerResponse;
import com.erp.postresponces.DeliveryResponce;
import com.erp.postresponces.InvoiceResponce;
import com.erp.postresponces.LoginResponceClass;
import com.erp.postresponces.SaleOrderResponse;
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
                else {
                    loginData.setValue(null);
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
        Log.d("_____False :", "come here " + location);
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

    public MutableLiveData<CustomerResponse> getCustomer(String Token) {
        MutableLiveData<CustomerResponse> customerData = new MutableLiveData<>();

        retrofitEndPoin.getCustomer(Token).enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

    public MutableLiveData<InvoiceResponce> getInvoices(String Token) {
        MutableLiveData<InvoiceResponce> customerData = new MutableLiveData<>();

        retrofitEndPoin.getInvoices(Token).enqueue(new Callback<InvoiceResponce>() {
            @Override
            public void onResponse(Call<InvoiceResponce> call, Response<InvoiceResponce> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<InvoiceResponce> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

    public MutableLiveData<InvoiceResponce> getInvoice(String Token,int id) {
        MutableLiveData<InvoiceResponce> customerData = new MutableLiveData<>();

        retrofitEndPoin.getInvoice(Token,id).enqueue(new Callback<InvoiceResponce>() {
            @Override
            public void onResponse(Call<InvoiceResponce> call, Response<InvoiceResponce> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<InvoiceResponce> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

    public MutableLiveData<DeliveryResponce> getDeliverys(String Token) {
        MutableLiveData<DeliveryResponce> customerData = new MutableLiveData<>();

        retrofitEndPoin.getDeliverys(Token).enqueue(new Callback<DeliveryResponce>() {
            @Override
            public void onResponse(Call<DeliveryResponce> call, Response<DeliveryResponce> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeliveryResponce> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

    public MutableLiveData<DeliveryResponce> getDelivery(String Token,int id) {
        MutableLiveData<DeliveryResponce> customerData = new MutableLiveData<>();

        retrofitEndPoin.getDelevery(Token,id).enqueue(new Callback<DeliveryResponce>() {
            @Override
            public void onResponse(Call<DeliveryResponce> call, Response<DeliveryResponce> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeliveryResponce> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

    public MutableLiveData<ConformationResponse> validateDelivery(String Token, int id) {
        MutableLiveData<ConformationResponse> customerData = new MutableLiveData<>();

        retrofitEndPoin.validateDelevery(Token,id).enqueue(new Callback<ConformationResponse>() {
            @Override
            public void onResponse(Call<ConformationResponse> call, Response<ConformationResponse> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ConformationResponse> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

    public MutableLiveData<SaleOrderResponse> getOrders(String Token) {
        MutableLiveData<SaleOrderResponse> customerData = new MutableLiveData<>();

        retrofitEndPoin.getSaleOrder(Token).enqueue(new Callback<SaleOrderResponse>() {
            @Override
            public void onResponse(Call<SaleOrderResponse> call, Response<SaleOrderResponse> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<SaleOrderResponse> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }
    public MutableLiveData<ConformationResponse> createCustomer(String Token, CreateCustomer customer) {
        MutableLiveData<ConformationResponse> customerData = new MutableLiveData<>();

        retrofitEndPoin.createCustomer(Token,customer).enqueue(new Callback<ConformationResponse>() {
            @Override
            public void onResponse(Call<ConformationResponse> call, Response<ConformationResponse> response) {
                if (response.isSuccessful()) {
//                    Log.d("_____False :",response.body().getSuccess().toString() );
                    customerData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ConformationResponse> call, Throwable t) {
                Log.d("_____False :", t.getMessage());
                customerData.setValue(null);

            }
        });
        return customerData;

    }

}
