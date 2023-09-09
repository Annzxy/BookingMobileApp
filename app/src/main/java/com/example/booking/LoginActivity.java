package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;
    private Spinner roleSpinnerLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize dummy data
        UserData.initialize(this);

        // Initialize the views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        roleSpinnerLogin = findViewById(R.id.roleSpinnerLogin);


        // Set the login button listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmail = emailEditText.getText().toString().trim();
                String inputPassword = passwordEditText.getText().toString().trim();
                String selectedRole = roleSpinnerLogin.getSelectedItem().toString();

                User user = UserData.getUser(inputEmail);
                if (user != null && user.password.equals(inputPassword) && user.role.name().equalsIgnoreCase(selectedRole)) {
                    SharedPreferences preferences = getSharedPreferences("current_user", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("0", user.email + ":" + user.password + ":" + user.role);
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Incorrect email, password, or role", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set the registration button listener
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
    }
}
