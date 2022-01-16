package com.erp.salesman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class erp_main_page_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erp_main_page);

        ImageView sale = findViewById(R.id.salepage);
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, SalesActivity.class);
                startActivity(intent);
            }
        });

        ImageView stokes = findViewById(R.id.stock_in_erp_page);
        stokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(erp_main_page_Activity.this, stoke_Activity.class);
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