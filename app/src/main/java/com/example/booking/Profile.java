package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView titleTextView, priceTextView, discountTextView, quantityTextView, bookingTimeTextView;
    private Button homeReturnButton;
    private TextView welcomeTextView, userRoleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Welcome text logic

        SharedPreferences preferences = getSharedPreferences("current_user", MODE_PRIVATE);
        String[] currentUserData = preferences.getString("0", "default").split(":");
        String email = currentUserData[0];
        String role = currentUserData[2];
        welcomeTextView = findViewById(R.id.welcomeTextView);
        userRoleTextView = findViewById(R.id.userRoleTextView);
        welcomeTextView.setText(String.format("Welcome, %s!", email));
        userRoleTextView.setText(String.format("User Role: %s", role));

        titleTextView = findViewById(R.id.titleTextView);
        priceTextView = findViewById(R.id.priceTextView);
        discountTextView = findViewById(R.id.discountTextView);
        quantityTextView = findViewById(R.id.quantityTextView);
        bookingTimeTextView = findViewById(R.id.bookingTimeTextView);

        homeReturnButton = findViewById(R.id.homeReturnButton);

        homeReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
                finish();  // Close the current activity
            }
        });

        loadBookingDetails();
    }

    private void loadBookingDetails() {
        SharedPreferences sharedPreferences = getSharedPreferences("item_details", MODE_PRIVATE);

        titleTextView.setText("Title: " + sharedPreferences.getString("title", "N/A"));
        priceTextView.setText("Price: " + sharedPreferences.getString("price", "N/A"));
        discountTextView.setText("Discount: " + sharedPreferences.getString("discount", "N/A"));
        quantityTextView.setText("Quantity: " + sharedPreferences.getString("quantity", "N/A"));
        bookingTimeTextView.setText("Booking Time: " + sharedPreferences.getString("booking_time", "N/A"));
    }
}
