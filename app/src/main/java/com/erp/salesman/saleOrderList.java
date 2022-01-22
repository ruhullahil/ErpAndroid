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
import com.erp.extraclass.SaleOrderAdapter;
import com.erp.extraclass.invoiceListAdapter;
import com.erp.postresponces.SOOrder;
import com.erp.viewmodel.OrderViewModel;
import com.erp.viewmodel.invoicesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class saleOrderList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private SaleOrderAdapter adapter;
    private ArrayList<SOOrder> soOrders = new ArrayList<>();
    private OrderViewModel ovm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_order_list);
        recyclerView = findViewById(R.id.recycle_view_sale_order);
        addButton = findViewById(R.id.add_sale_order);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        if ((token == null)) {
            Intent intent = new Intent(saleOrderList.this, MainActivity.class);
            startActivity(intent);
        }
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(saleOrderList.this, SalesActivity.class);
                startActivity(intent);
            }
        });
        ProgressDialog progress = new ProgressDialog(saleOrderList.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        ovm = new ViewModelProvider(this).get(OrderViewModel.class);
        ovm.init(token);
        ovm.getCustomerData().observe(this, SaleOrderResponse -> {
            if (SaleOrderResponse == null) {
                progress.dismiss();
                Toast.makeText(saleOrderList.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (SaleOrderResponse.getType() != null) {
                progress.dismiss();
                Toast.makeText(saleOrderList.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(saleOrderList.this, MainActivity.class);
                startActivity(intent);


            } else if (SaleOrderResponse.getSuccess()) {
                progress.dismiss();
                soOrders.addAll(SaleOrderResponse.getData());
                adapter.notifyDataSetChanged();
            } else {
                progress.dismiss();
                Toast.makeText(saleOrderList.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });
        setupRecyclerView();

    }
    private void setupRecyclerView() {
        if (adapter == null) {
            adapter = new SaleOrderAdapter(saleOrderList.this, soOrders);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}