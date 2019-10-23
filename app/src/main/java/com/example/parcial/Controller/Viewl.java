package com.example.parcial.Controller;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial.Model.Products;
import com.example.parcial.R;

import java.util.List;

public class Viewl extends RecyclerView.Adapter<Viewl.Holder> {

    List<Products> listProducts;
    public Viewl(List<Products> listProducts) {
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_holi,parent,false);
        Viewl.Holder holder = new Viewl.Holder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.p1.setText(listProducts.get(position).getProduct());
        holder.c1.setText(listProducts.get(position).getCategory());
        holder.q1 = listProducts.get(position).getQuantity();
    }


    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public class Holder  extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView p1,c1;
        String q1;
        CardView cardView;
        public Holder(@NonNull android.view.View itemView) {
            super(itemView);

            p1 = (TextView) itemView.findViewById(R.id.p1);
            c1 =(TextView) itemView.findViewById(R.id.c1);
            cardView =(CardView) itemView.findViewById(R.id.cardview1);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

            contextMenu.add(this.getAdapterPosition(),121,0,q1 );

        }
    }
}
