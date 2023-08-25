package com.junior.evc_4_final_sandoval_baldera_edgar_junior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE,MODE_PRIVATE);
        setContentView(binding.getRoot());
        boolean inSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED, false);
        if(inSessionActivated){
            Intent intent = new Intent(this,FruitHomeActivity.class);
            startActivity(intent);
            finish();
        }
        binding.btnAcceso.setOnClickListener(v -> {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Iniciemos session", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}