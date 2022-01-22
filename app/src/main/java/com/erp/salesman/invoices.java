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
import android.widget.Toast;

import com.erp.Common;
import com.erp.extraclass.invoiceListAdapter;
import com.erp.extraclass.stockListAdapter;
import com.erp.postresponces.InvoiceOrders;
import com.erp.postresponces.InvoiceResponce;
import com.erp.salesman.R;
import com.erp.viewmodel.invoicesViewModel;
import com.erp.viewmodel.locationStockViewModel;

import java.util.ArrayList;

public class invoices extends AppCompatActivity {
    private RecyclerView incoiveRecycleView;
    private invoicesViewModel invoicesVM;
    private ArrayList<InvoiceOrders> invoiceOrders = new ArrayList<>();
    private invoiceListAdapter invoiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoices);
        incoiveRecycleView = findViewById(R.id.recycle_view_in_invoices_page);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        if ((token == null)) {
            Intent intent = new Intent(invoices.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(invoices.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        invoicesVM = new ViewModelProvider(this).get(invoicesViewModel.class);
        invoicesVM.init(token);
        invoicesVM.getInvoiceData().observe(this, InvoiceResponce -> {
            if (InvoiceResponce == null) {
                progress.dismiss();
                Toast.makeText(invoices.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (InvoiceResponce.getType() != null) {
                progress.dismiss();
                Toast.makeText(invoices.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(invoices.this, MainActivity.class);
                startActivity(intent);


            } else if (InvoiceResponce.getSuccess()) {
                progress.dismiss();
                invoiceOrders.addAll(InvoiceResponce.getData());
                invoiceAdapter.notifyDataSetChanged();
            } else {
                progress.dismiss();
                Toast.makeText(invoices.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (invoiceAdapter == null) {
            invoiceAdapter = new invoiceListAdapter(invoices.this, invoiceOrders);
            incoiveRecycleView.setLayoutManager(new LinearLayoutManager(this));
            incoiveRecycleView.setAdapter(invoiceAdapter);
            incoiveRecycleView.setItemAnimator(new DefaultItemAnimator());
            incoiveRecycleView.setNestedScrollingEnabled(true);
        } else {
            invoiceAdapter.notifyDataSetChanged();
        }
    }
}