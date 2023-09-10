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

public class Activity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);  // Assuming the XML layout is named "activity_activity_category"

        // For the return button
        Button returnButton = findViewById(R.id.activityReturnButton);   // Adjust this ID if you have a different one in your XML for activity
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity.this, Home.class);
                startActivity(intent);
                finish();  // This will close the current activity (ActivityCategory) and return to Home.
            }
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.activityDealsRecyclerView);   // Adjust this ID if it's different in your XML layout

        // Create a list of activities
        List<ListItem> activityDeals = new ArrayList<>();

        // Dummy data for demonstration purposes
        activityDeals.add(new ListItem("Activity One", R.drawable.activity_one_image, "$30", "35% OFF"));
        activityDeals.add(new ListItem("Activity Two", R.drawable.activity_two_image, "$40", "20% OFF"));
        activityDeals.add(new ListItem("Activity Three", R.drawable.activity_three_image, "$50", "45% OFF"));
        // ... add as many activities as you want

        // Set the RecyclerView's layout manager and adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(activityDeals, this));
    }
}
