package com.example.booking;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GenericViewHolder extends RecyclerView.ViewHolder {

    ImageView dealListingImage;
    TextView dealListingTitle, dealListingPrice, dealListingDiscount;

    public GenericViewHolder(@NonNull View itemView) {
        super(itemView);

        dealListingImage = itemView.findViewById(R.id.dealListingImage);
        dealListingTitle = itemView.findViewById(R.id.dealListingTitle);
        dealListingPrice = itemView.findViewById(R.id.dealListingPrice);
        dealListingDiscount = itemView.findViewById(R.id.dealListingDiscount);
    }
}

