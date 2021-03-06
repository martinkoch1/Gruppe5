package com.example.sundmadnepal.SundNepal.data

import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *
 */


class RecipeRepositoryImpl(
    private val dao: RecipeDao
): RecipeRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return dao.getRecipes()
    }


    override suspend fun getRecipeByName(name: String): Recipe? {
        return dao.getRecipeByName(name)
    }

    override suspend fun addRecipe(recipe: Recipe) {
        dao.addRecipe(recipe)
    }


    override suspend fun addKeyIngredient(keyIngredient: List<KeyIngredient>){
        for (element in keyIngredient){
            dao.addKeyIngredient(element)
        }

    }


    override  fun getRecipeWithKeyIngredients(): Flow<List<RecipeWithKeyIngredients>> {
        return dao.getRecipeWithKeyIngredients()
    }

    override fun getRecipeWithKeyIngredientsAndSteps(): Flow<List<RecipeWithKeyIngredientsAndSteps>>{
        return dao.getRecipeWithKeyIngredientsAndSteps()
    }

    override suspend fun insertKeyIngredient(keyIngredient: KeyIngredient) {
        dao.insertKeyIngredient(keyIngredient)
    }

    override suspend fun insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef: RecipeKeyIngredientCrossRef) {
        dao.insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef)
    }

    override suspend fun insertSteps(steps: Steps) {
        dao.insertSteps(steps)
    }

    override fun getRecipeWithKeyIngredientsAndStepsByName(recipeName: String) :RecipeWithKeyIngredientsAndSteps{
       return dao.getRecipeWithKeyIngredientsAndStepsByName(recipeName)
    }

    override suspend fun UpdateFavorite(isFavorite: Int, recipeName: String) {
        dao.updateFavorite(isFavorite, recipeName)
    }

    override fun getImages(): Flow<List<String>>{
        return dao.getImages()
    }

}