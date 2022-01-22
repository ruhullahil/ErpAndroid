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
import com.erp.salesman.MainActivity;
import com.erp.salesman.R;
import com.erp.salesman.invoiceDetails;
import com.erp.salesman.invoices;

import java.util.ArrayList;

public class invoiceListAdapter extends RecyclerView.Adapter<invoiceListAdapter.ViewHplder> {
    private Context context;
    private ArrayList<InvoiceOrders> invoices = new ArrayList<>();

    public invoiceListAdapter(Context context, ArrayList<InvoiceOrders> invoices) {
        this.context = context;
        this.invoices = invoices;
    }

    @NonNull
    @Override
    public invoiceListAdapter.ViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.invoice_cart, parent, false);
        return new invoiceListAdapter.ViewHplder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull invoiceListAdapter.ViewHplder holder, int position) {
        holder.name.setText(invoices.get(position).getName());
        holder.customer.setText(invoices.get(position).getCustomer());
        holder.sale_order.setText(invoices.get(position).getSale_order());
        holder.tatal.setText(invoices.get(position).getTotal().toString());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, invoiceDetails.class);
                intent.putExtra("id",invoices.get(holder.getAdapterPosition()).getId());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return invoices.size();
    }

    public class ViewHplder extends RecyclerView.ViewHolder {
        private TextView customer;
        private TextView sale_order;
        private TextView name;
        private TextView tatal;
        private View mView;

        public ViewHplder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.address_order_view_page);
            customer = itemView.findViewById(R.id.customer_name_order_view_page);
            sale_order = itemView.findViewById(R.id.so_no);
            tatal = itemView.findViewById(R.id.total_prices_invoices);
            mView = itemView;

        }
    }
}
