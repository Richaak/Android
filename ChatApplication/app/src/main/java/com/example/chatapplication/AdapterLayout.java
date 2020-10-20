package com.example.chatapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLayout extends RecyclerView.Adapter<AdapterLayout.LayoutviewHolder> {
    public int posi;
    private ArrayList<Layoutt> mlayout;





    public static class LayoutviewHolder extends RecyclerView.ViewHolder{

        public TextView sender;
        public TextView message;

        public LayoutviewHolder(@NonNull View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.sendertv);
            message = itemView.findViewById(R.id.messagetv);
        }
    }

    public AdapterLayout(ArrayList<Layoutt> layout){
        mlayout = layout;
    }

    @NonNull
    @Override
    public LayoutviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutviewHolder lvh=null;
        View v=null;
        if(viewType==0){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sendmessage,parent,false);
        }else



            {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.receivemessage,parent,false);
        }

        lvh = new LayoutviewHolder(v);
        return lvh;
    }
    @Override
    public int getItemViewType(int position) {

        Message Message = new Message();
        ArrayList<String> neww;
        neww = Message.getName();
        if((neww.get(position)).equals(Message.getCurrentname())){
            return 0;
        }
        return 1;
    }



    @Override
    public void onBindViewHolder(@NonNull LayoutviewHolder holder, int position) {
        posi = position;
        Layoutt currentlayout =mlayout.get(position);
        holder.sender.setText(currentlayout.getName());
        holder.message.setText(currentlayout.getMsg());
        LinearLayout parent = (LinearLayout) ((ViewGroup) holder.sender.getParent()).getParent();
    }


    /*public void onBindViewHolder(@NonNull LayoutviewHolder holder, int position) {
        posi = position;
        Layoutt currentlayout =mlayout.get(position);
        holder.sender.setText(currentlayout.getname());
        holder.message.setText(currentlayout.getMssssg());
        LinearLayout parent = (LinearLayout) ((ViewGroup) holder.sender.getParent()).getParent();
    }*/










    @Override
    public int getItemCount() {
        return mlayout.size();
    }
}
