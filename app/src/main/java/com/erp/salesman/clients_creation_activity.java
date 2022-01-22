package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erp.Common;
import com.erp.postresponces.CreateCustomer;
import com.erp.viewmodel.createCustomerViewModel;
import com.erp.viewmodel.invoicesViewModel;

public class clients_creation_activity extends AppCompatActivity {
    private createCustomerViewModel cvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_creation);
        EditText clientname = findViewById(R.id.client_name_clients_creation_page);
        EditText address = findViewById(R.id.address_clients_creation_page);
        EditText mobile = findViewById(R.id.mobileclients_creation_page);
        EditText creditlimit = findViewById(R.id.credit_limite_clients_creation_page);
        EditText shoptype = findViewById(R.id.shop_typeclients_creation_page);
        cvm = new ViewModelProvider(this).get(createCustomerViewModel.class);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String token = prefs.getString("Token", null);
        int location = prefs.getInt("location", -1);
        if ((token == null)) {
            Intent intent = new Intent(clients_creation_activity.this, MainActivity.class);
            startActivity(intent);
        }
        ProgressDialog progress = new ProgressDialog(clients_creation_activity.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog

        Button submit = findViewById(R.id.submit_clients_creation_page);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             String name = clientname.getText().toString().trim();
             String adrs = address.getText().toString().trim();
             String mobil_number = mobile.getText().toString().trim();
             String credit_limit = creditlimit.getText().toString().trim();
             String Shop_name = shoptype.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    clientname.setError("Username is Required");
                    return;
                }
                if (TextUtils.isEmpty(adrs)) {
                    address.setError("Address is Required");
                    return;
                }

                if (TextUtils.isEmpty(mobil_number)) {
                    mobile.setError("Mobile is Required");
                    return;
                }

                if (TextUtils.isEmpty(credit_limit)) {
                    creditlimit.setError("Credit Limit is Required");
                    return;
                }
                if (TextUtils.isEmpty(Shop_name)) {
                    shoptype.setError("Shop Type is Required");
                    return;
                }
                CreateCustomer customer = new CreateCustomer(name,adrs,mobil_number);
                cvm.init(token,customer);
                progress.show();
                cvm.createCustomer().observe(clients_creation_activity.this, ConformationResponse -> {
                    if (ConformationResponse == null) {
                        progress.dismiss();
                        Toast.makeText(clients_creation_activity.this, "Some Thing went Wrong !! please check internet and Check again", Toast.LENGTH_LONG).show();
                    }  else if (ConformationResponse.getSuccess()) {
                        progress.dismiss();
                        Toast.makeText(clients_creation_activity.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();

                    } else {
                        progress.dismiss();
                        Toast.makeText(clients_creation_activity.this, "You have no Product in stock !!!", Toast.LENGTH_LONG).show();
                    }


                });


            }
        });








    }
}