package com.example.recipe_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnRegister;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        db = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!isValidEmail(email)){
                etEmail.setError("Enter valid email");
                return;
            }
            if(!isValidPassword(password)){
                etPassword.setError("Weak Password");
                return;
            }
            if (!password.equals(confirmPassword)) {
                etConfirmPassword.setError("Passwords do not match");
                return;
            }
            if (db.emailExists(email)) {
                etEmail.setError("Email already registered");
                return;
            }
            boolean inserted = db.insertUser(name,email,password);
            if(inserted){
                Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Register.this, Login.class));
                finish();
            }else{
                Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.txtGoLogin).setOnClickListener(v ->
                startActivity(new Intent(this, Login.class)));
    }

    private boolean isValidEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password){
        return password.length() >= 10 && password.matches(".*\\d.*");
    }
}
