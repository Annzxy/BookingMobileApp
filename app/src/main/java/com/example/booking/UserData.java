package com.example.booking;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class UserData {
    private static SharedPreferences preferences;
    private static final String PREF_NAME = "user_data";

    public static void initialize(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("customer@email.com", "123:admin");
        editor.putString("supplier@email.com", "123:supplier");
        editor.putString("admin@email.com", "123:admin");
        editor.apply();
    }

    public static User getUser(String email) {
        String data = preferences.getString(email, null);
        if (data != null) {
            String[] parts = data.split(":");
            String password = parts[0];
            UserRole role = UserRole.valueOf(parts[1].toUpperCase());
            return new User(email, password, role);
        }
        return null;
    }
}
