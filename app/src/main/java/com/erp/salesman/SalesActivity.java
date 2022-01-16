package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.erp.extraclass.sales_adapter;
import com.erp.extraclass.salesview_user;

import java.util.ArrayList;

public class SalesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<salesview_user> listuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        recyclerView = (RecyclerView) findViewById(R.id.sales_page_recycleView);
        listuser = new ArrayList<>();

        setuseinfo();
        setadapter();


    }

    private void setadapter() {
        sales_adapter adapter = new sales_adapter(listuser);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }

    private void setuseinfo() {

//        listuser.add(new salesview_user("bear"));



    }
}