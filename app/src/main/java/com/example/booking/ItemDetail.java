package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetail extends AppCompatActivity {

    private TextView itemTitle, itemPrice, itemDiscount;
    private ImageView itemImage;
    private EditText quantityEditText, timeEditText;
    private Button submitButton, buttonProfile, buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Initialize views
        itemTitle = findViewById(R.id.itemTitle);
        itemPrice = findViewById(R.id.itemPrice);
        itemDiscount = findViewById(R.id.itemDiscount);
        itemImage = findViewById(R.id.itemImage); // You can set the image here as required
        quantityEditText = findViewById(R.id.quantityEditText);
        timeEditText = findViewById(R.id.timeEditText);
        submitButton = findViewById(R.id.buttonSubmit);
        buttonProfile = findViewById(R.id.buttonProfile);
        buttonReturn = findViewById(R.id.buttonReturn);

        buttonReturn = findViewById(R.id.buttonReturn);

        buttonProfile = findViewById(R.id.buttonProfile);

        //Profile button
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetail.this, Profile.class);
                startActivity(intent);
            }
        });

        //Return button
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to Hotel page
                Intent intent = new Intent(ItemDetail.this, Hotel.class);
                startActivity(intent);
                finish();  // This will close the ItemDetail page and take you back to Hotel page.
            }
        });

        // Retrieve the extras
        String title = getIntent().getStringExtra("title");
        String price = getIntent().getStringExtra("price");
        String discount = getIntent().getStringExtra("discount");
        int imageResId = getIntent().getIntExtra("imageResId", -1); // -1 is a default value
        if (imageResId != -1) {
            itemImage.setImageResource(imageResId);
        }

        // Populate views with data from intent
        itemTitle.setText(title);
        itemPrice.setText(price);
        itemDiscount.setText(discount);

        loadDetailsFromSharedPreferences();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetailsToSharedPreferences();
                Toast.makeText(ItemDetail.this, "Booking successful!", Toast.LENGTH_SHORT).show();
            }
        });

        // TODO: Implement onClick listeners for buttonProfile and buttonReturn if needed
    }

    private void loadDetailsFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("item_details", MODE_PRIVATE);
        // You'd typically load data here that isn't already set from the intent
        // For example:
        quantityEditText.setText(sharedPreferences.getString("quantity", ""));
        timeEditText.setText(sharedPreferences.getString("booking_time", ""));
    }

    private void saveDetailsToSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("item_details", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("title", itemTitle.getText().toString());
        editor.putString("price", itemPrice.getText().toString());
        editor.putString("discount", itemDiscount.getText().toString());
        editor.putString("quantity", quantityEditText.getText().toString());
        editor.putString("booking_time", timeEditText.getText().toString());

        editor.apply();
    }
}