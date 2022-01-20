package com.erp.salesman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.erp.extraclass.stock_data;
import com.erp.extraclass.stock_dada_adapter;


import java.util.ArrayList;

public class stoke_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList <stock_data> list;
    private stock_dada_adapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoke);
        recyclerView = findViewById(R.id.recycler_view_stock_page);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new  ArrayList<stock_data>();
        myadapter = new stock_dada_adapter(stoke_Activity.this,list);
        recyclerView.setAdapter(myadapter);
    }
}