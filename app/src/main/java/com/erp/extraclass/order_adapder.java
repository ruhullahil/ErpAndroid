package com.erp.extraclass;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.salesman.R;

import org.json.JSONArray;

import java.util.ArrayList;

public class order_adapder extends RecyclerView.Adapter<order_adapder.ViewHolder> {

    private ArrayList<order_user> orderlist;
    private RecyclerViewClickListener listener;



    public order_adapder( ArrayList<order_user> orderlist, RecyclerViewClickListener listener) {
        this.orderlist = orderlist;
        this.listener = listener;
    }


    @NonNull
    @Override
    public order_adapder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderview, parent, false);
        return new order_adapder.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String cname = orderlist.get(position).getCustomer_name();
        holder.cus_name.setText(cname);
        String cusadress = orderlist.get(position).getAddress();
        holder.cus_address.setText(cusadress);
        String cusTotal = orderlist.get(position).getTotal_price();
        holder.cus_total.setText(cusTotal);

    }

    @Override
    public int getItemCount() {
        return orderlist.size();

    }

    public interface RecyclerViewClickListener{

        void onClick(View view, int position);

    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView cus_name, cus_address, cus_total;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cus_name = itemView.findViewById(R.id.customer_name_order_view_page);
            cus_address = itemView.findViewById(R.id.address_order_view_page);
            cus_total = itemView.findViewById(R.id.product_Total_order_view_page);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            listener.onClick(itemView, getAdapterPosition());

        }


    }
}
