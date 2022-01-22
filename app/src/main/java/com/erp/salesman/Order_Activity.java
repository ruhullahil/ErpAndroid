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
import com.erp.extraclass.deliveryOrderAdapter;
import com.erp.extraclass.invoiceListAdapter;
import com.erp.extraclass.order_adapder;
import com.erp.extraclass.order_user;
import com.erp.postresponces.DeliveryOrder;
import com.erp.viewmodel.DeliverysViewModel;
import com.erp.viewmodel.invoicesViewModel;

import java.util.ArrayList;

public class Order_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DeliveryOrder> orderlist;
    private DeliverysViewModel deliveyVM;
    private deliveryOrderAdapter  deliveryAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recyclerView = findViewById(R.id.recycle_view_in_order_page);
        orderlist = new ArrayList<>();
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        if ((token == null)) {
            Intent intent = new Intent(Order_Activity.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(Order_Activity.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        deliveyVM = new ViewModelProvider(this).get(DeliverysViewModel.class);
        deliveyVM.init(token);
        deliveyVM.getInvoiceData().observe(this, DeliveryResponce -> {
            if (DeliveryResponce == null) {
                progress.dismiss();
                Toast.makeText(Order_Activity.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (DeliveryResponce.getType() != null) {
                progress.dismiss();
                Toast.makeText(Order_Activity.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Order_Activity.this, MainActivity.class);
                startActivity(intent);


            } else if (DeliveryResponce.getSuccess()) {
                progress.dismiss();
                orderlist.addAll(DeliveryResponce.getData());
                deliveryAdapter.notifyDataSetChanged();
            } else {
                progress.dismiss();
                Toast.makeText(Order_Activity.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });
        setupRecyclerView();




    }
    private void setupRecyclerView() {
        if (deliveryAdapter == null) {
            deliveryAdapter = new deliveryOrderAdapter(Order_Activity.this, orderlist);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(deliveryAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            deliveryAdapter.notifyDataSetChanged();
        }
    }


}