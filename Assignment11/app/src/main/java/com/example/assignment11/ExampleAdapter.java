package com.example.assignment11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<exampleitem> mExamplelist;

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        View card1;
        public TextView mtextview;
        public Button mbutton;

        public ExampleViewHolder(@NonNull final View itemView) {
            super(itemView);
            mtextview = itemView.findViewById(R.id.textview);
            mbutton = itemView.findViewById(R.id.button);
            card1=itemView.findViewById(R.id.card);



          /*  mbutton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    mtextview.setText("");
                    Snackbar snackbar=Snackbar.make(card1,"Text is deleted! Do you want to restore?",Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {


                        @Override
                    public void onClick(View view) {
                       // mtextview.setText("hey");

                        Snackbar snackbar1 = Snackbar.make(card1, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

                    snackbar.show();
                }
            });*/

        }

    }

    public ExampleAdapter(ArrayList<exampleitem> examplelist) {
        mExamplelist = examplelist;
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
        holder.mtextview.setText(currentitem.getMtextview());
        holder.mbutton.setText(currentitem.getMbutton());
        holder.card1.findViewById(R.id.card);
        holder.mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mExamplelist.remove(position);
                notifyItemRangeChanged(position,getItemCount());
                notifyItemRemoved(position);
                Snackbar snackbar=Snackbar.make(holder.card1,"Text is deleted! Do you want to restore?",Snackbar.LENGTH_LONG).setDuration(5000).setAction("UNDO!!", new View.OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {

                        mExamplelist.add(position,currentitem);
                        notifyItemInserted(position);
                        notifyItemRangeChanged(position,getItemCount());
                    }
                });

                snackbar.show();
            }

        });





    }


    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }
}





