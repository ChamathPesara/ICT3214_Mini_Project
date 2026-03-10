# 🍲 My Cook Book – Recipe Management Android App

## 📌 Project Overview

**My Cook Book** is a user-friendly Android application designed to help users **store, manage, and organize their personal recipes in one place**.
The app provides a simple interface where users can create an account, securely log in, and manage their own collection of recipes.

Users can **add, view, edit, and delete recipes**, making it easier to keep track of their favorite meals, cooking instructions, and ingredients. Each user has their **own private recipe collection**, ensuring that recipes are personalized and securely stored.

This project was developed as part of an academic mini project to demonstrate **Android development concepts, database integration, and UI design principles**.

---

# 🎯 Objectives

The main objectives of this project are:

* To develop a **mobile application for managing personal recipes**
* To implement **user authentication and database management**
* To demonstrate **CRUD operations (Create, Read, Update, Delete)** in an Android application
* To design a **simple and intuitive user interface for mobile users**

---

# ✨ Features

### 👤 User Authentication

* User registration system
* Secure login using email and password
* Unique user accounts stored in the database
* Verifications for email and password 

### 📖 Recipe Management

* Add new recipes
* View previously added recipes
* Edit existing recipes
* Delete recipes

### 📂 Personalized Recipe Storage

* Recipes are linked to the logged-in user
* Each user can only view and manage their own recipes

### 🧾 Recipe Details

Each recipe contains:

* Recipe Name
* Ingredients
* Cooking Instructions

### 🎨 User Interface

* Modern and simple design
* Gradient background UI
* Card-based recipe display
* Emoji-based recipe icon 🍲
* Clean and user-friendly layout

### 📱 Mobile Friendly Design

* Scrollable layouts
* Optimized for Android mobile screens
* Easy navigation between pages

---

# 🏗️ Application Architecture

The application follows a **basic Android architecture structure** with separate components for:

* Activities (User Interface & Interaction)
* Database Helper (SQLite operations)
* Models (Recipe data representation)
* Adapters (RecyclerView item display)

### Main Components

| Component               | Description                                       |
| ----------------------- | ------------------------------------------------- |
| **MainActivity**        | Home screen with Sign In / Create Account options |
| **LoginActivity**       | Handles user login                                |
| **RegisterActivity**    | Allows users to create new accounts               |
| **AddRecipeActivity**   | Add or update recipes                             |
| **ViewRecipesActivity** | Displays recipes in a RecyclerView                |
| **RecipeAdapter**       | Connects recipe data to UI cards                  |
| **DatabaseHelper**      | Manages SQLite database operations                |
| **Recipe**              | Represents recipe data                            |

---

# 🗄️ Database Design

The application uses **SQLite**, Android's built-in local database system.

## Users Table

| Column   | Description          |
| -------- | -------------------- |
| id       | Primary key          |
| name     | User's name          |
| email    | Unique email address |
| password | User password        |

## Recipes Table

| Column       | Description          |
| ------------ | -------------------- |
| id           | Recipe ID            |
| name         | Recipe name          |
| ingredients  | List of ingredients  |
| instructions | Cooking instructions |
| user_email   | Owner of the recipe  |

This structure ensures **each recipe belongs to a specific user**.

---

# 🛠️ Technologies Used

### Programming Languages

* **Java** – Core application logic
* **XML** – User interface design

### Development Tools

* **Android Studio** – Primary IDE for development
* **Android Emulator** – Testing environment

### Database

* **SQLite** – Local database storage

### Android Components

* Activities
* RecyclerView
* CardView
* Intents
* SQLiteOpenHelper

### UI/UX Elements

* Gradient backgrounds
* Custom fonts
* Rounded card designs
* Emoji icons for recipes

---

# 📂 Project Structure

```
MyCookBook
│
├── java/com/example/recipe_app
│   ├── MainActivity.java
│   ├── LoginActivity.java
│   ├── RegisterActivity.java
│   ├── AddRecipeActivity.java
│   ├── ViewRecipes.java
│   ├── RecipeAdapter.java
│   ├── DatabaseHelper.java
│   └── Recipe.java
│
├── res
│   ├── layout
│   ├── drawable
│   ├── values
│   └── font
│
└── AndroidManifest.xml
```

---

# 🚀 How to Run the Project

1. Clone the repository

```
git clone https://github.com/ChamathPesara/ICT3214_Mini_Project
```

2. Open the project in **Android Studio**

3. Build and run the application using:

* Android Emulator
  or
* Physical Android device

4. Register a new account and start managing your recipes.

---

# 📸 Application Screens

The app includes the following main screens:

* Welcome Screen
* Login Screen
* Register Screen
* Add Recipe Screen
* View Recipes Screen
* Edit / Delete Recipe Options

---

# 👨‍💻 Team Members

| Name           | Role                                                          | Reg No       |
| -------------- | --------------------------------------------------------------| -------------|
| Chamath Pesara | View Recipes activity, Database Integration, UI modifications | ICT/2022/006 |
| SKeerthy       | Login and registration activities, Database Integration       | ICT/2022/007 |
| miyuruwan      | Add Recipes activity                                          | ICT/2022/008 |

---

# 📚 Learning Outcomes

Through this project we gained practical experience in:

* Android application development
* Designing mobile user interfaces
* Working with SQLite databases
* Implementing CRUD functionality
* Managing user authentication
* Using RecyclerView and adapters

---

# 🔮 Future Improvements

Potential enhancements for the application include:

* Adding recipe images
* Cloud database integration (Firebase)
* Recipe search functionality
* Recipe categories (Desserts, Drinks, etc.)
* Favorite recipes feature
* Sharing recipes with other users

---

# 📄 License

This project is created for **educational purposes** and academic demonstration.

---

⭐ If you found this project useful or interesting, feel free to give it a star!
# ICT3214_Mini_Project
A recipe collection mobile app created using Android Studio
