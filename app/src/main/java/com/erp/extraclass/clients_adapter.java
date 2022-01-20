package com.erp.extraclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erp.salesman.R;

import java.util.ArrayList;

public class clients_adapter extends RecyclerView.Adapter<clients_adapter.ViewHplder> {

    private ArrayList<client_user> clientslist;
    public clients_adapter( ArrayList<client_user> clientslist) {
        this.clientslist = clientslist;
    }

    @NonNull
    @Override
    public clients_adapter.ViewHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.clientsview, parent, false);

        return new clients_adapter.ViewHplder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull clients_adapter.ViewHplder holder, int position) {

        String clientname = clientslist.get(position).getClient_name();
        holder.client_name1.setText(clientname);
        String shopaddress = clientslist.get(position).getShop_address();
        holder.shop_address1.setText(shopaddress);
        String clientcontact = clientslist.get(position).getClient_contact();
        holder.client_contact1.setText(clientcontact);
    }

    @Override
    public int getItemCount() {
       return clientslist.size();
    }

    public static class ViewHplder extends RecyclerView.ViewHolder{

        private TextView client_name1, shop_address1, client_contact1;

        public ViewHplder(@NonNull View itemView) {
            super(itemView);

            client_name1 = itemView.findViewById(R.id.clients_name_client_view_page);
            shop_address1 = itemView.findViewById(R.id.shop_address_client_view_page);
            client_contact1 = itemView.findViewById(R.id.client_contact_client_view_page);

        }
    }
}
