package com.example.recipe_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecipe extends AppCompatActivity {
    TextView tvPageTitle;
    EditText etRecipeName, etIngredients, etInstructions;
    Button btnConfirm, btnExit;
    DatabaseHelper db;
    String userEmail;
    private int recipeId = -1;
    private boolean isEditMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        // Initialize database
        db = new DatabaseHelper(this);

        // Get user email from intent
        userEmail = getIntent().getStringExtra("email");

        // Link views
        etRecipeName = findViewById(R.id.etRecipeName);
        etIngredients = findViewById(R.id.etIngredients);
        etInstructions = findViewById(R.id.etInstructions);
        btnConfirm = findViewById(R.id.btnSaveRecipe);
        btnExit = findViewById(R.id.btnCancel);
        tvPageTitle = findViewById(R.id.tvPageTitle);

        // Confirm button
        btnConfirm.setOnClickListener(v -> {

            String name = etRecipeName.getText().toString();
            String ingredients = etIngredients.getText().toString();
            String instructions = etInstructions.getText().toString();

            if (isEditMode) {
                db.updateRecipe(recipeId, name, ingredients, instructions);
                Toast.makeText(this, "Recipe Updated!", Toast.LENGTH_SHORT).show();
            } else {
                db.insertRecipe(name, ingredients, instructions,userEmail);
                Toast.makeText(this, "Recipe Added!", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(this, ViewRecipes.class);
            intent.putExtra("email", userEmail);
            startActivity(intent);
            finish();
        });

        // Exit button
        btnExit.setOnClickListener(v -> finish());

        //Modify existing data
        recipeId = getIntent().getIntExtra("recipe_id", -1);

        if (recipeId != -1) {

            isEditMode = true;
            if (recipeId != -1) {

                isEditMode = true;

                tvPageTitle.setText("Update Your Recipe");

                Recipe recipe = db.getRecipeById(recipeId);

                if (recipe != null) {
                    etRecipeName.setText(recipe.getName());
                    etIngredients.setText(recipe.getIngredients());
                    etInstructions.setText(recipe.getInstructions());
                    btnConfirm.setText("Update Recipe");
                }
            }

            Recipe recipe = db.getRecipeById(recipeId);

            if (recipe != null) {
                etRecipeName.setText(recipe.getName());
                etIngredients.setText(recipe.getIngredients());
                etInstructions.setText(recipe.getInstructions());
                btnConfirm.setText("Update Recipe");
            }
        }
    }

    private void addRecipe() {

        String name = etRecipeName.getText().toString().trim();
        String ingredients = etIngredients.getText().toString().trim();
        String instructions = etInstructions.getText().toString().trim();
        String imageString = null;

        // Validation
        if (name.isEmpty() || ingredients.isEmpty() || instructions.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean inserted = db.insertRecipe(name, ingredients, instructions,userEmail);

        if (inserted) {
            Toast.makeText(this, "Recipe Added Successfully!", Toast.LENGTH_SHORT).show();

            // Clear fields
            etRecipeName.setText("");
            etIngredients.setText("");
            etInstructions.setText("");

        } else {
            Toast.makeText(this, "Failed to Add Recipe", Toast.LENGTH_SHORT).show();
        }
    }
}