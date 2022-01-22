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
import com.erp.extraclass.client_user;
import com.erp.extraclass.clients_adapter;
import com.erp.postresponces.CustomerResponse;
import com.erp.viewmodel.customerViewModel;
import com.erp.viewmodel.locationStockViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Clients_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<client_user> clientslist = new ArrayList<>();
    private customerViewModel customerVM;
    private clients_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);



        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_clients_page);

        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);

        if ((token == null)) {
            Intent intent = new Intent(Clients_Activity.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(Clients_Activity.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        customerVM = new ViewModelProvider(this).get(customerViewModel.class);
        customerVM.init(token);
        customerVM.getCustomerData().observe(this, CustomerResponse -> {
            if (CustomerResponse == null) {
                progress.dismiss();
                Toast.makeText(Clients_Activity.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
            } else if (CustomerResponse.getType() != null) {
                progress.dismiss();
                Toast.makeText(Clients_Activity.this, "You Token expired or invalid !! please Login Again", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Clients_Activity.this, MainActivity.class);
                startActivity(intent);


            } else if (CustomerResponse.getSuccess()){
                progress.dismiss();
                clientslist.addAll(CustomerResponse.getData());
                adapter.notifyDataSetChanged();
            }
            else {
                progress.dismiss();
                Toast.makeText(Clients_Activity.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
            }


        });

        setadapter();

        FloatingActionButton floatingActionButton = findViewById(R.id.FAB_clients_activity);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clients_Activity.this, clients_creation_activity.class);
                startActivity(intent);
            }
        });
    }



    private void setadapter() {
        if (adapter == null) {
            adapter = new clients_adapter(clientslist);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }
        else{
            adapter.notifyDataSetChanged();
        }
    }
}