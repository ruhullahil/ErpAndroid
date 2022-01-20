package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.erp.Common;
import com.erp.extraclass.order_adapder;
import com.erp.extraclass.stockListAdapter;
import com.erp.postresponces.StockResponse;
import com.erp.viewmodel.locationStockViewModel;

import java.util.ArrayList;

public class stockList extends AppCompatActivity {
    private RecyclerView stockRecycleView;
    private ArrayList<StockResponse> stockResponses = new ArrayList<>();
    private stockListAdapter stockAdapder;
    private locationStockViewModel stockVM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_list);
        stockRecycleView = findViewById(R.id.recycle_view_in_stock_page);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        int location = prefs.getInt("location", -1);
        if ((token == null) || (location == -1)) {
            Intent intent = new Intent(stockList.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(stockList.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        stockVM = new ViewModelProvider(this).get(locationStockViewModel.class);
        stockVM.init(token, location);
        stockVM.getStockData().observe(this, stockLocatonResponce -> {
            if (stockLocatonResponce == null) {
                progress.dismiss();
                Toast.makeText(stockList.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (stockLocatonResponce.getType() != null) {
                progress.dismiss();
                Toast.makeText(stockList.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(stockList.this, MainActivity.class);
                startActivity(intent);


            } else if (stockLocatonResponce.getSuccess()){
                progress.dismiss();
                stockResponses.addAll(stockLocatonResponce.getData());
                stockAdapder.notifyDataSetChanged();
            }
            else {
                progress.dismiss();
                Toast.makeText(stockList.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });
        setupRecyclerView();


    }

    private void setupRecyclerView() {
        if (stockAdapder == null) {
            stockAdapder = new stockListAdapter(stockList.this, stockResponses);
            stockRecycleView.setLayoutManager(new LinearLayoutManager(this));
            stockRecycleView.setAdapter(stockAdapder);
            stockRecycleView.setItemAnimator(new DefaultItemAnimator());
            stockRecycleView.setNestedScrollingEnabled(true);
        } else {
            stockAdapder.notifyDataSetChanged();
        }
    }

}
