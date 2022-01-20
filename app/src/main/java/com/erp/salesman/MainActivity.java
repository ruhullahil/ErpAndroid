package com.erp.salesman;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.erp.Common;
import com.erp.postresponces.LoginResponceClass;
import com.erp.viewmodel.loginViewModel;

public class MainActivity extends AppCompatActivity {
    private loginViewModel loginViewModels;
    private String db = Common.DB_NAME;
    private LoginResponceClass loginResponceClasss = new LoginResponceClass();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = this.getSharedPreferences(
                Common.SHIRE_PREFERENCE, Context.MODE_PRIVATE);
        String Token = prefs.getString("Token", null);
        if (Token != null) {
            Intent intent = new Intent(MainActivity.this, erp_main_page_Activity.class);
            startActivity(intent);
        }


        EditText editText1 = (EditText) findViewById(R.id.user_login_page);
        EditText editText2 = (EditText) findViewById(R.id.password_in_login_page);
        TextView textview = (TextView) findViewById(R.id.login_button_in_login_page);
        loginViewModels = new ViewModelProvider(this).get(loginViewModel.class);

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText1.getText().toString().trim();
                String password = editText2.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    editText1.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editText2.setError("Password is Required");
                    return;
                }
                if (password.length() < 3) {
                    editText2.setError("Password will be Minimum 3 Character");
                    return;
                }
                Toast.makeText(MainActivity.this, "Button work", Toast.LENGTH_LONG).show();
                ProgressDialog progress = new ProgressDialog(MainActivity.this);
                progress.setTitle("Loading");
                progress.setMessage("Wait while loading...");
                progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                progress.show();
                loginViewModels.init(email, password, db);
                loginViewModels.getNewsRepository().observe(MainActivity.this, loginResponceClass -> {
                    if (loginResponceClass != null) {
                        loginResponceClasss = loginResponceClass;
                        prefs.edit().putString("Token", loginResponceClass.getAccessToken()).apply();
                        prefs.edit().putString("user_name", loginResponceClass.getUserName()).apply();
                        prefs.edit().putInt("uid", loginResponceClass.getUid()).apply();
                        progress.dismiss();
                        Intent intent = new Intent(MainActivity.this, erp_main_page_Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Button work", Toast.LENGTH_LONG).show();
                        progress.dismiss();
                    }

                });


            }
        });
    }
}