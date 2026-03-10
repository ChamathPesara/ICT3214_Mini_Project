package com.example.recipe_app;

public class Recipe {

    private int id;
    private String name;
    private String ingredients;
    private String instructions;
    private String userEmail;

    public Recipe(int id, String name, String ingredients,
                  String instructions, String userEmail) {

        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.userEmail = userEmail;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getUserEmail() {
        return userEmail;
    }

}
