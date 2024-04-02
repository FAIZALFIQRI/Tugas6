package com.example.tugas6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Model> modellist;

    private final Context context;

    public Adapter(ArrayList<Model> models,Context context) {
        this.modellist = models;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final Model model = modellist.get(position);
        holder.jenisSepatu.setText(model.getJenisSepatu());
        holder.namaSepatu.setText(model.getDeskSepatu());
        holder.hargaSepatu.setText(model.getHargaSepatu());
        holder.gambarSepatu.setImageResource(model.getGambarSepatu());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailItem.class);
                intent.putExtra("itemId", model.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jenisSepatu;
        TextView namaSepatu;
        TextView hargaSepatu;
        ImageView gambarSepatu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jenisSepatu = itemView.findViewById(R.id.Jenissepatu);
            namaSepatu = itemView.findViewById(R.id.Textsepatu);
            hargaSepatu = itemView.findViewById(R.id.Hargasepatu);
            gambarSepatu = itemView.findViewById(R.id.Sepatu);
        }
    }
}
