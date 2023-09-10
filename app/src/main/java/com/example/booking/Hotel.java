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

public class Hotel extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        // For the return button
        Button returnButton = findViewById(R.id.hotelReturnButton);   // Make sure this ID matches the one in your XML
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotel.this, Home.class);
                startActivity(intent);
                finish();  // This will close the current activity (Hotel) and return to Home.
            }
        });


        // Initialize RecyclerView
        recyclerView = findViewById(R.id.hotelDealsRecyclerView);  // Replace 'recyclerView' with your RecyclerView's ID if it's different

        // Create a list of hotels
        List<ListItem> hotelDeals = new ArrayList<>();

        // Dummy data for demonstration purposes; You'll likely retrieve this from a database or an API
        hotelDeals.add(new ListItem("Hotel One", R.drawable.hotel_one_image, "$250", "30% OFF"));
        hotelDeals.add(new ListItem("Hotel Two", R.drawable.hotel_two_image, "$180", "45% OFF"));
        hotelDeals.add(new ListItem("Hotel Three", R.drawable.hotel_three_image, "$480", "55% OFF"));
        // ... add as many hotels as you want

        // Set the RecyclerView's layout manager and adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(hotelDeals, this));
    }
}