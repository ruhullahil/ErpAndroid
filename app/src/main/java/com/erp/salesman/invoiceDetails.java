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
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.erp.Common;
import com.erp.extraclass.InvoiceLineListAdapter;
import com.erp.extraclass.invoiceListAdapter;
import com.erp.extraclass.sales_adapter;
import com.erp.extraclass.salesview_user;
import com.erp.postresponces.InvoiceLine;
import com.erp.postresponces.InvoiceOrders;
import com.erp.viewmodel.invoicesViewModel;

import java.util.ArrayList;

public class invoiceDetails extends AppCompatActivity {
    private invoicesViewModel invoicesVM;
    private ArrayList<InvoiceOrders> invoiceOrders = new ArrayList<>();
    private TextView name , customer,sale_order,total;
    private RecyclerView recyclerView;
    private ArrayList<InvoiceLine> order_line = new ArrayList<>();
    private InvoiceLineListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_details);
        name = findViewById(R.id.invoice_name);
        customer = findViewById(R.id.customer_invice);
        sale_order = findViewById(R.id.invoice_sale_order);
        total = findViewById(R.id.invoice_total);
        recyclerView = findViewById(R.id.detail_invoice_recycleView);
        int id = getIntent().getIntExtra("id",-1);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        int location = prefs.getInt("location", -1);
        if ((token == null)) {
            Intent intent = new Intent(invoiceDetails.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(invoiceDetails.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        invoicesVM = new ViewModelProvider(this).get(invoicesViewModel.class);
        invoicesVM.getsSingleInvoiceData(token,id).observe(this, InvoiceResponce -> {
            if (InvoiceResponce == null) {
                progress.dismiss();
                Toast.makeText(invoiceDetails.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (InvoiceResponce.getType() != null) {
                progress.dismiss();
                Toast.makeText(invoiceDetails.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(invoiceDetails.this, MainActivity.class);
                startActivity(intent);


            } else if (InvoiceResponce.getSuccess()) {
                progress.dismiss();
                order_line.addAll(InvoiceResponce.getData().get(0).getOrder_line());
                invoiceOrders.addAll(InvoiceResponce.getData());
                name.setText(invoiceOrders.get(0).getName());
                customer.setText(invoiceOrders.get(0).getCustomer());
                sale_order.setText(invoiceOrders.get(0).getSale_order());
                total.setText(invoiceOrders.get(0).getTotal().toString());

                Log.d("tu----------", String.valueOf(order_line.size()));

                adapter.notifyDataSetChanged();



            } else {
                progress.dismiss();
                Toast.makeText(invoiceDetails.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });
        setupRecyclerView();
    }
    private void setupRecyclerView() {
        if (adapter == null) {
            adapter = new InvoiceLineListAdapter(this,order_line);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

}