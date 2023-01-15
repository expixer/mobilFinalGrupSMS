package com.example.grupsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText etEposta, etPassword;
    Button btnLogin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEposta = findViewById(R.id.login_eTEposta);
        etPassword = findViewById(R.id.login_eTSifre);
        btnLogin = findViewById(R.id.login_btnLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(v -> {
            String eposta = etEposta.getText().toString();
            String password = etPassword.getText().toString();

            if(eposta.isEmpty() || password.isEmpty()){
                Toast.makeText(LoginActivity.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(eposta, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(this, "Giriş Başarısız", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}