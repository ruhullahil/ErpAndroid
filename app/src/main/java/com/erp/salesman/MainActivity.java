package com.erp.salesman;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editText1 = (EditText) findViewById(R.id.user_login_page);
        EditText editText2 = (EditText)  findViewById(R.id.password_in_login_page);
        TextView textview = (TextView) findViewById(R.id.login_button_in_login_page);

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
                if (password.length() < 6) {
                    editText2.setError("Password will be Minimum 6 Character");
                    return;
                }
                Toast.makeText(MainActivity.this, "Button work",Toast.LENGTH_LONG).show();

                Intent intent = new Intent( MainActivity.this, erp_main_page_Activity.class);
                startActivity(intent);

            }
        });
    }
}