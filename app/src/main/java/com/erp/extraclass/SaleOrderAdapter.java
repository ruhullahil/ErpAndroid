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
import com.erp.postresponces.SOOrder;
import com.erp.salesman.DeleveryDetails;
import com.erp.salesman.R;

import java.util.ArrayList;

public class SaleOrderAdapter extends RecyclerView.Adapter<SaleOrderAdapter.ViewHplder> {
    private Context context;
    private ArrayList<SOOrder> deliveryOrders = new ArrayList<>();

    public SaleOrderAdapter(Context context, ArrayList<SOOrder> deliveryOrders) {
        this.context = context;
        this.deliveryOrders = deliveryOrders;
    }

    @NonNull
    @Override
    public SaleOrderAdapter.ViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sale_order_cart, parent, false);
        return new SaleOrderAdapter.ViewHplder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleOrderAdapter.ViewHplder holder, int position) {
        holder.total.setText(deliveryOrders.get(position).getTotal().toString());
        holder.customerName.setText(deliveryOrders.get(position).getCustomer());
        holder.saleOrder.setText(deliveryOrders.get(position).getName());
//        holder.nview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DeleveryDetails.class);
//                intent.putExtra("id",deliveryOrders.get(holder.getAdapterPosition()).getId());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return deliveryOrders.size();
    }

    public class ViewHplder extends RecyclerView.ViewHolder {
        private TextView total;
        private TextView customerName;
        private TextView saleOrder;
        private View nview;

        public ViewHplder(@NonNull View itemView) {
            super(itemView);
            total = itemView.findViewById(R.id.sale_order_amount);
            customerName = itemView.findViewById(R.id.sale_order_customer);
            saleOrder = itemView.findViewById(R.id.sale_order_name);
            nview = itemView;


        }
    }
}
