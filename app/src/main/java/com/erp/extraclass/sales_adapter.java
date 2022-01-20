package com.erp.extraclass;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.salesman.R;

import java.util.ArrayList;

public class sales_adapter extends RecyclerView.Adapter<sales_adapter.ViewHolder> {

    private ArrayList<salesview_user> listuser;

    public sales_adapter( ArrayList<salesview_user> listuser) {
        this.listuser = listuser;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.salesview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String Product_name = listuser.get(position).getSale_product();
        holder.sale_product1.setText(Product_name);
        String Product_quantity = listuser.get(position).getSalas_quantity();
        holder.salas_quantity1.setText(Product_quantity);
        String Product_total = listuser.get(position).getSales_total();
        holder.sales_total1.setText(Product_total);

    }

    @Override
    public int getItemCount() {
        return listuser.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView sale_product1, salas_quantity1, sales_total1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sale_product1 = itemView.findViewById(R.id.product_name_in_sales_view_page);
            salas_quantity1 =itemView.findViewById(R.id.product_quantity_in_sales_view_page);
            sales_total1 = itemView.findViewById(R.id.product_Total_price_in_sales_view_page);



        }


    }

}
