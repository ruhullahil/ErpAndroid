package com.erp.networking;

import com.erp.postresponces.CustomerResponse;
import com.erp.postresponces.LoginResponceClass;
import com.erp.postresponces.StockResponse;
import com.erp.postresponces.getSaleManInfo;
import com.erp.postresponces.getSaleOrderResponse;
import com.erp.postresponces.stockLocatonResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitEndPoin {
    @GET("auth/token")
    Call<LoginResponceClass> getToken(@Query("login") String user, @Query("password") String password, @Query("db") String db);

    @GET("res.partner")
    Call<List<CustomerResponse>> getCustomerList(@Header("access_token") String Token);

    @GET("get_order")
    Call<getSaleOrderResponse> getSaleOrder(@Header("access_token") String Token);

    @GET("get_sales_man_info")
    Call<getSaleManInfo> getSalesManInfo(@Header("access_token") String Token);

    @GET("get_stock_quant/{id}")
    Call<stockLocatonResponce> getLocationStock(@Header("access_token") String Token, @Path("id") Integer id);


}
