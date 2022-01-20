package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.erp.extraclass.order_adapder;
import com.erp.extraclass.order_user;

import java.util.ArrayList;

public class Order_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<order_user> orderlist;
    private order_adapder.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recyclerView = findViewById(R.id.recycle_view_in_order_page);
        orderlist = new ArrayList<>();


        setuseinfo();
        setadater();
    }

    private void setadater() {
        order_adapder adapter = new order_adapder(orderlist, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        setOnClickListener();
    }

    private void setOnClickListener() {
        listener = new order_adapder.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

//               Toast toast = new Toast(getApplicationContext(), "ggyu",Toast.LENGTH_LONG);
            }
        };
    }

    private void setuseinfo() {

        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));
        orderlist.add(new order_user("tomal","Tulshighat,Gaibandha,Rungpur","400"));




    }


}