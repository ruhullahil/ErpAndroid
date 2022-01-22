package com.erp.salesman;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.erp.Common;
import com.erp.postresponces.saleManData;
import com.erp.viewmodel.erpMainPageViewModel;

import java.util.ArrayList;

public class erp_main_page_Activity extends AppCompatActivity {
    private erpMainPageViewModel erpViewModelpage;
    private TextView salesman;
    private TextView sale_count;
    private ArrayList<saleManData> saleinfo = new ArrayList<saleManData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erp_main_page);
        salesman = findViewById(R.id.username_erp_page);
        sale_count = findViewById(R.id.sales_erp_page);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        if (token.equals(null)) {
            Intent intent = new Intent(erp_main_page_Activity.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(erp_main_page_Activity.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        erpViewModelpage = new ViewModelProvider(this).get(erpMainPageViewModel.class);
        erpViewModelpage.init(token);
        erpViewModelpage.getSalesManInfo().observe(this, getSaleManInfo -> {
            if (getSaleManInfo == null) {
                progress.dismiss();
                Toast.makeText(erp_main_page_Activity.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();

            } else if (getSaleManInfo.getType() == null) {
                saleinfo.addAll(getSaleManInfo.getData());
                progress.dismiss();
                for (saleManData data : saleinfo) {
                    salesman.setText(data.getName());
                    sale_count.setText(Integer.toString(data.getSale_count()));
                    prefs.edit().putInt("location",data.getLocation_id()).apply();
                }

            } else {
                prefs.edit().putString("Token", null).apply();
                progress.dismiss();
                Toast.makeText(erp_main_page_Activity.this, "Your Token is invalid or expired !! please login again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(erp_main_page_Activity.this, MainActivity.class);
                startActivity(intent);

            }

        });


        ImageView sale = findViewById(R.id.salepage);
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, saleOrderList.class);
                startActivity(intent);
            }
        });

        ImageView stokes = findViewById(R.id.stock_in_erp_page);
        stokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, stockList.class);
                startActivity(intent);
            }
        });

        ImageView clients = findViewById(R.id.clients_user_activity);
        clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, Clients_Activity.class);
                startActivity(intent);
            }
        });


        ImageView order = findViewById(R.id.order_in_erp_main_page);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, Order_Activity.class);
                startActivity(intent);
            }
        });

        ImageView invoice = findViewById(R.id.erp_main_invoices);
        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, invoices.class);
                startActivity(intent);
            }
        });
        ImageView collection =  findViewById(R.id.payment_collection);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, creditList.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Continue with delete operation

                finishAffinity();
            }
        });
        builder.setNegativeButton(android.R.string.no, null);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.show();// Specifying a listener allows you to take an action before dismissing the dialog.
// The dialog is automatically dismissed when a dialog button is clicked.
// A null listener allows the button to dismiss the dialog and take no further action.

    }
}