package com.example.recipe_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvWelcome;
    DatabaseHelper db;
    Button btnAddRecipe, btnViewRecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvWelcome = findViewById(R.id.tvWelcome);
        db = new DatabaseHelper(this);

        // get email from intent
        String email = getIntent().getStringExtra("email");

        // get name from database
        String name = db.getNameByEmail(email);

        // set welcome text
        tvWelcome.setText("Welcome , " + name);

        btnAddRecipe = findViewById(R.id.btnAddRecipe);
        btnViewRecipes = findViewById(R.id.btnViewRecipes);

        btnAddRecipe.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddRecipe.class);
            intent.putExtra("email",email);
            startActivity(intent);
        });

        btnViewRecipes.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ViewRecipes.class)));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}