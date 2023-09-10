package com.example.booking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GenericAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private List<ListItem> items;
    private Context context;

    public GenericAdapter(List<ListItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listing, parent, false);
        return new GenericViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        ListItem currentItem = items.get(position);

        holder.dealListingTitle.setText(currentItem.getTitle());
        holder.dealListingImage.setImageResource(currentItem.getImageResId());
        holder.dealListingPrice.setText(currentItem.getPrice());
        holder.dealListingDiscount.setText(currentItem.getDiscount());

        // Add onClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtra("title", currentItem.getTitle());
                intent.putExtra("price", currentItem.getPrice());
                intent.putExtra("discount", currentItem.getDiscount());
                intent.putExtra("imageResId", currentItem.getImageResId());
                // Optionally add more data as needed
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

