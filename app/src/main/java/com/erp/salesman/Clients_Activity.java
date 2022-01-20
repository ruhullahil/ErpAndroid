package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.erp.extraclass.client_user;
import com.erp.extraclass.clients_adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Clients_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<client_user> clientslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);



        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_clients_page);
        clientslist = new ArrayList<>();

        setuseinfo();
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

    private void setuseinfo() {

        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));
        clientslist.add(new client_user("tomal","Tulshighat,Gaibandha,Rungpur","1234567890"));



    }

    private void setadapter() {
        clients_adapter adapter = new clients_adapter(clientslist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}