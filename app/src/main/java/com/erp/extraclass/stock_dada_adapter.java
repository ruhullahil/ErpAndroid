package com.erp.extraclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.salesman.R;

import java.util.ArrayList;

public class stock_dada_adapter extends RecyclerView.Adapter<stock_dada_adapter.mystock_dada_adapter> {

    Context context;

    ArrayList <stock_data> list;

    public stock_dada_adapter(Context context, ArrayList<stock_data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public mystock_dada_adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view_activity,parent, false);
        return new mystock_dada_adapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mystock_dada_adapter holder, int position) {
        stock_data data = list.get(position);
        holder.ProductName.setText(data.getProductName());
        holder.ProductQuantity.setText(data.getProductQuantity());
        holder.Warehouse.setText(data.getWarehouse());
        holder.Price.setText(data.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class mystock_dada_adapter extends RecyclerView.ViewHolder{

        TextView ProductName, ProductQuantity, Warehouse, Price;

        public mystock_dada_adapter(@NonNull View itemView) {
            super(itemView);

            ProductName = itemView.findViewById(R.id.product_name_in_stock_page);
            ProductQuantity = itemView.findViewById(R.id.product_quentiy_in_stock_page);
            Warehouse = itemView.findViewById(R.id.warehouse_name_in_stock_page);
            Price = itemView.findViewById(R.id.price_name_in_stock_page);
        }
    }



}
