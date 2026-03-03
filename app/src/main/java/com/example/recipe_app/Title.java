package com.example.recipe_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Title extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        findViewById(R.id.btnLogin).setOnClickListener(v ->
                startActivity(new Intent(this, Login.class)));

        findViewById(R.id.btnRegister).setOnClickListener(v ->
                startActivity(new Intent(this, Register.class)));
    }
}
