package com.evgeniykim.vpntest.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.evgeniykim.vpntest.MainActivity;
import com.evgeniykim.vpntest.R;
import com.evgeniykim.vpntest.model.Model;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private ArrayList<Model> models;

    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }


    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.countries_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        Model model = models.get(position);
        holder.setdetails(model);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position1 = holder.getAdapterPosition();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("position", position1);
                intent.putExtra("Flag", model.getmImage());
                intent.putExtra("State", model.getmName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView flag;
        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position1 = getAdapterPosition();
//                    Intent intent = new Intent(context, MainActivity.class);
//                    intent.putExtra("position", position1);
//                    context.startActivity(intent);
//
//                }
//            });

            flag = itemView.findViewById(R.id.mImage);
            name = itemView.findViewById(R.id.mName);
        }

        public void setdetails(Model model) {
            Glide.with(context).load(model.getmImage()).into(flag);
            name.setText(model.getmName());
        }
    }
}
