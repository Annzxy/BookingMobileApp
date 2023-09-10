package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView restaurantSearchView;
    private GenericAdapter adapter;
    private List<ListItem> restaurantDeals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        // For the return button
        Button returnButton = findViewById(R.id.restaurantReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Restaurant.this, Home.class);
                startActivity(intent);
                finish();  // This will close the current activity (Restaurant) and return to Home.
            }
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.restaurantDealsRecyclerView);

        // Initialize SearchView
        restaurantSearchView = findViewById(R.id.restaurantSearchView);
        restaurantSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        // Dummy data for demonstration purposes
        restaurantDeals.add(new ListItem("Restaurant One", R.drawable.restaurant_one_image, "$80", "50% OFF"));
        restaurantDeals.add(new ListItem("Restaurant Two", R.drawable.restaurant_two_image, "$65", "45% OFF"));
        restaurantDeals.add(new ListItem("Restaurant Three", R.drawable.restaurant_three_image, "$90", "30% OFF"));

        // Initialize and set the RecyclerView's layout manager and adapter
        adapter = new GenericAdapter(restaurantDeals, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
