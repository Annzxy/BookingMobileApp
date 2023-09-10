package com.example.booking;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryVH extends RecyclerView.ViewHolder {

    ImageView categoryImageView;
    TextView categoryTitleView;

    RecyclerView recyclerView;

    public CategoryVH(@NonNull View categoryRV) {
        super(categoryRV);

        categoryImageView = categoryRV.findViewById(R.id.categoryImage);
        categoryTitleView = categoryRV.findViewById(R.id.categoryTitle);

        recyclerView = categoryRV.findViewById(R.id.categoryRV);
    }
}

