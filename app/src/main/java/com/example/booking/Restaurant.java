package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);   // Make sure you have a corresponding XML layout for restaurants

        // For the return button
        Button returnButton = findViewById(R.id.restaurantReturnButton);   // Adjust this ID if you have a different one in your XML for restaurant
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Restaurant.this, Home.class);
                startActivity(intent);
                finish();  // This will close the current activity (Restaurant) and return to Home.
            }
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.restaurantDealsRecyclerView);   // Adjust this ID if it's different in your XML layout

        // Create a list of restaurants
        List<ListItem> restaurantDeals = new ArrayList<>();

        // Dummy data for demonstration purposes; You'll likely retrieve this from a database or an API
        restaurantDeals.add(new ListItem("Restaurant One", R.drawable.restaurant_one_image, "$80", "50% OFF"));
        restaurantDeals.add(new ListItem("Restaurant Two", R.drawable.restaurant_two_image, "$65", "45% OFF"));
        restaurantDeals.add(new ListItem("Restaurant Three", R.drawable.restaurant_three_image, "$90", "30% OFF"));
        // ... add as many restaurants as you want

        // Set the RecyclerView's layout manager and adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(restaurantDeals, this));
    }
}
