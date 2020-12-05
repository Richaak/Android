package com.example.a1818_isa2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<exampleitem> mExamplelist;
    Context co;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        View card1;
        public TextView mappearance;
        public TextView mname;
        public TextView mnickname;
        public TextView mportrayed;
        public ImageView mimage;
        public Button medit;

        public ExampleViewHolder(@NonNull final View itemView) {
            super(itemView);

            mname=itemView.findViewById(R.id.name);
            mnickname=itemView.findViewById(R.id.nickname);
            mappearance = itemView.findViewById(R.id.appearance);
            mportrayed=itemView.findViewById(R.id.portrayed);
            mimage=itemView.findViewById(R.id.image);
            medit=itemView.findViewById(R.id.edit);



        }

    }

    public ExampleAdapter(ArrayList<exampleitem> examplelist, Context con) {
    //    Log.e("hi","hii");
        mExamplelist = examplelist;
        co=con;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {
        final exampleitem currentitem = mExamplelist.get(position);
     //   Log.e("hi","hii"+position);
        holder.mname.setText(currentitem.getName());
        holder.mnickname.setText(currentitem.getNickname());
        holder.mportrayed.setText(currentitem.getPortrayed());
        holder.mappearance.setText(currentitem.getAppearance());
        holder.medit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co, edit.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("nickname",currentitem.getNickname());
                co.startActivity(intent);

            }
        });
        //display image using glide
        Glide.with(co)
                .load(currentitem.getImg())
                .into(holder.mimage);


    }


    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }
}