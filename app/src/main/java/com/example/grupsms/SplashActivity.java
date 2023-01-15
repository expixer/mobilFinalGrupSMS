package com.example.grupsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.registerButton).setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
        findViewById(R.id.loginButton).setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            Toast.makeText(this, "Tekrar Hoşgeldiniz!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            //finish();
        }
    }
}