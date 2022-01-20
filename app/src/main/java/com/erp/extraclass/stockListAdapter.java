package com.erp.extraclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.postresponces.StockResponse;
import com.erp.salesman.R;

import java.util.ArrayList;

public class stockListAdapter extends RecyclerView.Adapter<stockListAdapter.ViewHolder>{
    private ArrayList<StockResponse> orderlist;
    Context context;



    public stockListAdapter(Context context, ArrayList<StockResponse> orderlist) {
        this.orderlist = orderlist;
        this.context = context;

    }


    @NonNull
    @Override
    public stockListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_cart, parent, false);
        return new stockListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull stockListAdapter.ViewHolder holder, int position) {
        String cname = orderlist.get(position).getProduct();
        holder.cus_name.setText(cname);
        String cusadress = String.valueOf(orderlist.get(position).getQuantity());
        holder.cus_address.setText(cusadress);
        String cusTotal = String.valueOf(orderlist.get(position).getLocation());
        holder.cus_total.setText(cusTotal);

    }

    @Override
    public int getItemCount() {
        return orderlist.size();

    }

    public interface RecyclerViewClickListener{

        void onClick(View view, int position);

    }



    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView cus_name, cus_address, cus_total;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cus_name = itemView.findViewById(R.id.customer_name_order_view_page);
            cus_address = itemView.findViewById(R.id.address_order_view_page);
            cus_total = itemView.findViewById(R.id.product_Total_order_view_page);
        }



    }
}
