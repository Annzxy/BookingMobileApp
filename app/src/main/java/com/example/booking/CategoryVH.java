package com.example.booking;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryVH extends RecyclerView.ViewHolder {

    ImageView categoryImageView;
    TextView categoryTitleView;

    public CategoryVH(@NonNull @org.jetbrains.annotations.NotNull View categoryRV) {
        super(categoryRV);

        categoryImageView = categoryRV.findViewById(R.id.categoryImage);
        categoryTitleView = categoryRV.findViewById(R.id.categoryTitle);

    }
}

