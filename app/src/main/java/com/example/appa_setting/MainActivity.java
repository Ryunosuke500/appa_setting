package com.example.appa_setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // push button to setting screen
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // change layout loot background by theme setting
        RelativeLayout root = findViewById(R.id.root);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch (defaultSharedPreferences.getString("preference_theme", getString(R.string.default_value_preference_theme))) {
            case "light":
                root.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            case "dark":
                root.setBackgroundColor(Color.parseColor("#000000"));
                break;
        }
    }

}