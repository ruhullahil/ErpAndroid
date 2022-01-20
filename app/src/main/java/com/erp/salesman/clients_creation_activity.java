package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class clients_creation_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_creation);
        EditText clientname = findViewById(R.id.client_name_clients_creation_page);
        EditText address = findViewById(R.id.address_clients_creation_page);
        EditText mobile = findViewById(R.id.mobileclients_creation_page);
        EditText creditlimit = findViewById(R.id.credit_limite_clients_creation_page);
        EditText shoptype = findViewById(R.id.shop_typeclients_creation_page);

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


            }
        });








    }
}