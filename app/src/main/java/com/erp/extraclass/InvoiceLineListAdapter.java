package com.erp.extraclass;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.postresponces.InvoiceLine;
import com.erp.postresponces.InvoiceOrders;
import com.erp.salesman.R;
import com.erp.salesman.invoiceDetails;

import java.util.ArrayList;

public class InvoiceLineListAdapter extends RecyclerView.Adapter<InvoiceLineListAdapter.ViewHplder> {
    private Context context;
    private ArrayList<InvoiceLine> invoices = new ArrayList<>();

    public InvoiceLineListAdapter(Context context, ArrayList<InvoiceLine> invoices) {
        this.context = context;
        this.invoices = invoices;
    }

    @NonNull
    @Override
    public InvoiceLineListAdapter.ViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.salesview, parent, false);
        return new InvoiceLineListAdapter.ViewHplder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceLineListAdapter.ViewHplder holder, int position) {
        holder.product.setText(invoices.get(position).getProduct());
//        Log.d("=======data++",invoices.get(position).getQuantity().toString());
        holder.quantity.setText(invoices.get(position).getQuantity().toString());
        holder.tatal.setText(invoices.get(position).getTotal().toString());




    }

    @Override
    public int getItemCount() {
        return invoices.size();
    }

    public class ViewHplder extends RecyclerView.ViewHolder {
        private TextView quantity;
        private TextView product;
        private TextView tatal;
        private View mView;

        public ViewHplder(@NonNull View itemView) {
            super(itemView);
            product = itemView.findViewById(R.id.product_name_in_sales_view_page);
            quantity = itemView.findViewById(R.id.product_quantity_in_sales_view_page);
            tatal = itemView.findViewById(R.id.product_Total_price_in_sales_view_page);
            mView = itemView;

        }
    }
}
