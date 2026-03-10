package com.example.recipe_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewRecipes extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper dbHelper;
    String email;
    TextView txtEmpty;
    List<Recipe> recipeList;
    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_recipes);
        txtEmpty = findViewById(R.id.txtEmpty);
        recyclerView = findViewById(R.id.recyclerViewRecipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        email = getIntent().getStringExtra("email");

        if (email == null) {
            Toast.makeText(this, "User email not found!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        dbHelper = new DatabaseHelper(this);
        recipeList = dbHelper.getUserRecipes(email);
        adapter = new RecipeAdapter(this, recipeList);
        recyclerView.setAdapter(adapter);
        checkIfEmpty();

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        recipeList.clear();
        recipeList.addAll(dbHelper.getUserRecipes(email));
        adapter.notifyDataSetChanged();

        checkIfEmpty();
    }
    public void checkIfEmpty() {
        if (recipeList.isEmpty()) {
            txtEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txtEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

}