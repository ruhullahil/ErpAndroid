package com.erp.extraclass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.postresponces.InvoiceOrders;
import com.erp.postresponces.deliveryOrderLine;
import com.erp.salesman.R;
import com.erp.salesman.invoiceDetails;

import java.util.ArrayList;

public class DeliveryListAdapter extends RecyclerView.Adapter<DeliveryListAdapter.ViewHplder> {
    private Context context;
    private ArrayList<deliveryOrderLine> invoices = new ArrayList<>();

    public DeliveryListAdapter(Context context, ArrayList<deliveryOrderLine> invoices) {
        this.context = context;
        this.invoices = invoices;
    }

    @NonNull
    @Override
    public DeliveryListAdapter.ViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.delevery_details, parent, false);
        return new DeliveryListAdapter.ViewHplder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryListAdapter.ViewHplder holder, int position) {
        holder.product.setText(invoices.get(position).getProduct());
        holder.quantity.setText(invoices.get(position).getQuantity().toString());


    }

    @Override
    public int getItemCount() {
        return invoices.size();
    }

    public class ViewHplder extends RecyclerView.ViewHolder {
        private TextView quantity;
        private TextView product;
        private View mView;

        public ViewHplder(@NonNull View itemView) {
            super(itemView);
            product = itemView.findViewById(R.id.product_name_in_sales_view_page);
            quantity = itemView.findViewById(R.id.product_quantity_in_sales_view_page);

            mView = itemView;

        }
    }
}
