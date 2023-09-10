package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements SelectCategory {

    private TextView welcomeTextView;
    private RecyclerView recyclerView;

    private Button buttonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Welcome text logic
        welcomeTextView = findViewById(R.id.welcomeTextView);
        SharedPreferences preferences = getSharedPreferences("current_user", MODE_PRIVATE);
        String[] currentUserData = preferences.getString("0", "default").split(":");
        String email = currentUserData[0];
        welcomeTextView.setText(String.format("Welcome, %s!", email));

        buttonProfile = findViewById(R.id.profileButton);

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(Home.this, Profile.class);
                startActivity(profileIntent);
            }
        });

        //Recyclerview
        recyclerView = findViewById(R.id.categoryRV);

        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Hotel", R.drawable.hotel_icon));
        categories.add(new Category("Restaurant", R.drawable.restaurant_icon));
        categories.add(new Category("Activity", R.drawable.activity_icon));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CategoryVA(categories, this, this));


    }

    @Override
    public void onCategoryClick(Category category) {
        Toast.makeText(this, category.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
