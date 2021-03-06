package com.example.sundmadnepal.SundNepal.presentation.util

sealed class Screen (val route: String){
    object RecipeScreen: Screen("recipe_screen")
    object HomeScreen: Screen("home_screen")
    object RecipeMenu: Screen("recipeMenu_screen")
    object ProfileScreen: Screen("profile_screen")
    object AboutScreen: Screen("about_screen")
    object IngredientScreen: Screen( "ingredient_screen")
    object StepsScreen: Screen ("steps_screen")
    object FavoriteScreen: Screen ("favorite_screen")
    object AddRecipe: Screen("addRecipe_screen")
    object ChooseKeyIngredient: Screen("chooseKeyIngredient_screen")
    object AddRecipeIngredient: Screen("addRecipeIngredient_screen")
    object AddRecipeSteps: Screen("addRecipeSteps_screen")


    object HealthInfoScreen: Screen("HealthInfo_screen")
    object HealthAdult: Screen("healthAdult_screen")
    object HealthBaby: Screen("healthBaby_screen")
    object HealthChildren: Screen("healthChildren_screen")
    object HealthPregnant: Screen("healthPregnant_screen")
}
