package com.example.attempt_3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList stock_id, stock_ticker, stock_cost, stock_quantity;

    int position;

    CustomAdapter(Activity activity, Context context, ArrayList stock_id, ArrayList stock_ticker, ArrayList stock_cost, ArrayList stock_quantity){
        this.activity = activity;
        this.context = context;
        this.stock_id = stock_id;
        this.stock_ticker = stock_ticker;
        this.stock_cost = stock_cost;
        this.stock_quantity = stock_quantity;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        this.position = position;
        holder.stock_ticker_txt.setText(String.valueOf((stock_ticker.get(position))));
        holder.stock_cost_txt.setText(String.valueOf((stock_cost.get(position))));
        holder.stock_quantity_txt.setText(String.valueOf((stock_quantity.get(position))));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id",String.valueOf((stock_id.get(position))));
                intent.putExtra("ticker",String.valueOf((stock_ticker.get(position))));
                intent.putExtra("cost",String.valueOf((stock_cost.get(position))));
                intent.putExtra("quantity",String.valueOf((stock_quantity.get(position))));
                activity.startActivityForResult(intent,1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return stock_ticker.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView stock_id_txt, stock_ticker_txt, stock_cost_txt, stock_quantity_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            stock_ticker_txt = itemView.findViewById(R.id.stockTickerText);
            stock_cost_txt = itemView.findViewById(R.id.stockCostText);
            stock_quantity_txt = itemView.findViewById(R.id.stockQuantityText);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
