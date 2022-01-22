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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.erp.Common;
import com.erp.extraclass.DeliveryListAdapter;
import com.erp.extraclass.InvoiceLineListAdapter;
import com.erp.postresponces.DeliveryOrder;
import com.erp.postresponces.InvoiceLine;
import com.erp.postresponces.InvoiceOrders;
import com.erp.postresponces.deliveryOrderLine;
import com.erp.viewmodel.DeliverysViewModel;
import com.erp.viewmodel.invoicesViewModel;

import java.util.ArrayList;

public class DeleveryDetails extends AppCompatActivity {
    private DeliverysViewModel invoicesVM;
    private ArrayList<DeliveryOrder> invoiceOrders = new ArrayList<>();
    private TextView name, customer, sale_order;
    private RecyclerView recyclerView;
    private ArrayList<deliveryOrderLine> order_line = new ArrayList<>();
    private DeliveryListAdapter adapter;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delevery_details);
        name = findViewById(R.id.delivery_name);
        customer = findViewById(R.id.customer_delivery);
        sale_order = findViewById(R.id.delivery_sale_order);
        validateButton = findViewById(R.id.delivery_button_validate);
        recyclerView = findViewById(R.id.detail_delivery_recycleView);
        int id = getIntent().getIntExtra("id", -1);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        if ((token == null)) {
            Intent intent = new Intent(DeleveryDetails.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(DeleveryDetails.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        invoicesVM = new ViewModelProvider(this).get(DeliverysViewModel.class);
        invoicesVM.getSigleDelevery(token, id).observe(this, DeliveryResponse -> {
            if (DeliveryResponse == null) {
                progress.dismiss();
                Toast.makeText(DeleveryDetails.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (DeliveryResponse.getType() != null) {
                progress.dismiss();
                Toast.makeText(DeleveryDetails.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DeleveryDetails.this, MainActivity.class);
                startActivity(intent);


            } else if (DeliveryResponse.getSuccess()) {
                progress.dismiss();
                order_line.addAll(DeliveryResponse.getData().get(0).getOrder_line());
                invoiceOrders.addAll(DeliveryResponse.getData());
                name.setText(invoiceOrders.get(0).getName());
                customer.setText(invoiceOrders.get(0).getCustomer());
                sale_order.setText(invoiceOrders.get(0).getSale_order());


                Log.d("tu----------", String.valueOf(order_line.size()));

                adapter.notifyDataSetChanged();


            } else {
                progress.dismiss();
                Toast.makeText(DeleveryDetails.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });


        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.show();
                invoicesVM.validateDelivery(token, id).observe(DeleveryDetails.this, conformationResponse -> {
                    if (conformationResponse == null) {
                        progress.dismiss();
                        Toast.makeText(DeleveryDetails.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();

                    } else if (conformationResponse.getSuccess()) {
                        progress.dismiss();
                        Toast.makeText(DeleveryDetails.this, "Your Delivery validate successfully !!!", Toast.LENGTH_LONG).show();
                    } else {
                        progress.dismiss();
                        Toast.makeText(DeleveryDetails.this, "Your Delivery maybe already validate !! please check in erp", Toast.LENGTH_LONG).show();
                    }


                });
            }
        });

        setupRecyclerView();
    }


    private void setupRecyclerView() {
        if (adapter == null) {
            adapter = new DeliveryListAdapter(this, order_line);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}