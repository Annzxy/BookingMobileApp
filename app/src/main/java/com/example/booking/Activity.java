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

public class Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView activitySearchView;
    private GenericAdapter adapter;
    private List<ListItem> activityDeals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        // For the return button
        Button returnButton = findViewById(R.id.activityReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.activityDealsRecyclerView);

        // Initialize SearchView
        activitySearchView = findViewById(R.id.activitySearchView);
        activitySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        activityDeals.add(new ListItem("Activity One", R.drawable.activity_one_image, "$30", "35% OFF"));
        activityDeals.add(new ListItem("Activity Two", R.drawable.activity_two_image, "$40", "20% OFF"));
        activityDeals.add(new ListItem("Activity Three", R.drawable.activity_three_image, "$50", "45% OFF"));

        // Initialize and set the RecyclerView's layout manager and adapter
        adapter = new GenericAdapter(activityDeals, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
