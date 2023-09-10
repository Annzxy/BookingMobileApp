package com.example.booking;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryVA extends RecyclerView.Adapter<CategoryVH> {
    Context context;
    List<Category> categories;

    SelectCategory selectCategoryListener;

    public CategoryVA(List<Category> categories, SelectCategory selectCategoryListener, Context context) {

        this.categories = categories;
        this.selectCategoryListener = selectCategoryListener;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_view, parent, false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, @SuppressLint("RecyclerView") int position) {
        holder.categoryTitleView.setText(categories.get(position).getTitle());
        holder.categoryImageView.setImageResource(categories.get(position).getCategoryImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                switch (categories.get(position).getTitle()) {
                    case "Hotel":
                        intent = new Intent(context, Hotel.class);
                        break;
                    case "Restaurant":
                        intent = new Intent(context, Restaurant.class);
                        break;
                    case "Activity":
                        intent = new Intent(context, Activity.class);
                        break;
                    default:
                        return;
                }


                context.startActivity(intent);

            }
        });

    }

    ;

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
