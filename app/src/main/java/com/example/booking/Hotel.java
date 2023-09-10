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

public class Hotel extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView hotelSearchView;
    private GenericAdapter adapter;
    private List<ListItem> hotelDeals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        // For the return button
        Button returnButton = findViewById(R.id.hotelReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotel.this, Home.class);
                startActivity(intent);
                finish();  // This will close the current activity (Hotel) and return to Home.
            }
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.hotelDealsRecyclerView);

        // Initialize SearchView
        hotelSearchView = findViewById(R.id.hotelSearchView);
        hotelSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        hotelDeals.add(new ListItem("Hotel One", R.drawable.hotel_one_image, "$250", "30% OFF"));
        hotelDeals.add(new ListItem("Hotel Two", R.drawable.hotel_two_image, "$180", "45% OFF"));
        hotelDeals.add(new ListItem("Hotel Three", R.drawable.hotel_three_image, "$480", "55% OFF"));

        // Initialize and set the RecyclerView's layout manager and adapter
        adapter = new GenericAdapter(hotelDeals, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
