package com.erp.extraclass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.postresponces.DeliveryOrder;
import com.erp.salesman.DeleveryDetails;
import com.erp.salesman.R;
import com.erp.salesman.invoiceDetails;

import java.util.ArrayList;

public class deliveryOrderAdapter extends RecyclerView.Adapter<deliveryOrderAdapter.ViewHplder> {
    private Context context;
    private ArrayList<DeliveryOrder> deliveryOrders = new ArrayList<>();

    public deliveryOrderAdapter(Context context, ArrayList<DeliveryOrder> deliveryOrders) {
        this.context = context;
        this.deliveryOrders = deliveryOrders;
    }

    @NonNull
    @Override
    public deliveryOrderAdapter.ViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderview, parent, false);
        return new deliveryOrderAdapter.ViewHplder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull deliveryOrderAdapter.ViewHplder holder, int position) {
        holder.deleveryId.setText(deliveryOrders.get(position).getName());
        holder.customerName.setText(deliveryOrders.get(position).getCustomer());
        holder.saleOrder.setText(deliveryOrders.get(position).getSale_order());
        holder.nview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeleveryDetails.class);
                intent.putExtra("id",deliveryOrders.get(holder.getAdapterPosition()).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return deliveryOrders.size();
    }

    public class ViewHplder extends RecyclerView.ViewHolder {
        private TextView deleveryId;
        private TextView customerName;
        private TextView saleOrder;
        private View nview;

        public ViewHplder(@NonNull View itemView) {
            super(itemView);
            deleveryId = itemView.findViewById(R.id.delevery_id_txt);
            customerName = itemView.findViewById(R.id.customer_name_order_view_page);
            saleOrder = itemView.findViewById(R.id.address_order_view_page);
            nview = itemView;


        }
    }
}
