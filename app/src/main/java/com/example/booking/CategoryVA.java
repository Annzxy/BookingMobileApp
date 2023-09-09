package com.example.booking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryVA extends RecyclerView.Adapter<CategoryVH> {
    Context context;
    List<Category> categories;

    public CategoryVA(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryVH(LayoutInflater.from(context).inflate(R.layout.category_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        holder.categoryTitleView.setText(categories.get(position).getTitle());
        holder.categoryImageView.setImageResource(categories.get(position).getCategoryImage());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
