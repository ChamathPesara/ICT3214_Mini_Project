package com.example.recipe_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnLogin;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        db = new DatabaseHelper(this);
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(Login.this, "Enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean valid = db.checkUser(email, password);
            if(valid){
                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(Login.this,"Invalid email and password",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.txtGoRegister).setOnClickListener(v ->
                startActivity(new Intent(this, Register.class)));
    }
}
