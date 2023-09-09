package com.example.booking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText regEmailEditText;
    private EditText regPasswordEditText;
    private Spinner roleSpinner;
    private Button regSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize the views
        regEmailEditText = findViewById(R.id.regEmailEditText);
        regPasswordEditText = findViewById(R.id.regPasswordEditText);
        roleSpinner = findViewById(R.id.roleSpinner);
        regSubmitButton = findViewById(R.id.regSubmitButton);

        // Set up spinner with roles
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        // Set the registration submit button listener
        regSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmail = regEmailEditText.getText().toString().trim();
                String inputPassword = regPasswordEditText.getText().toString().trim();
                String selectedRole = roleSpinner.getSelectedItem().toString().toUpperCase();

                if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // This is dummy registration - we're just checking if user exists
                // If you had a real backend, you'd send this data to it for registration
                if (UserData.getUser(inputEmail) == null) {
                    Toast.makeText(RegistrationActivity.this, "Registered successfully (dummy)", Toast.LENGTH_SHORT).show();

                    // You could save the newly registered user into SharedPreferences here if you wanted
                    SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(inputEmail, inputPassword + ":" + selectedRole);
                    editor.apply();

                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegistrationActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
