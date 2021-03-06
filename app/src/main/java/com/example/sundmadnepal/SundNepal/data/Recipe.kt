package com.example.sundmadnepal.SundNepal.data

import androidx.annotation.DrawableRes
import androidx.room.*
import com.example.sundmadnepal.R

/**
 * Define what kind of data we have
 */

data class RecipeLocal(
    val recipeName: String,
    val image: String,
    val prepTime: String,
    val energy: String,
    val healthy: String,
    val information: String,
    val keyIngrediens: List<KeyIngredient>,
    //val steps: List<steps>
)

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = false)
    val recipeName: String,
    val image: String,
    val prepTime: String,
    val energy: String,
    val healthy: String,
    val information: String,
    val favorite: Int
    //val keyIngrediens: List<KeyIngredient>,
    //val steps: List<steps>
)

@Entity
data class KeyIngredient(
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val unit: String,
    val amount: Int,
    val image: String
)

@Entity(primaryKeys = ["recipeName", "title"])
data class RecipeKeyIngredientCrossRef(
    val recipeName: String,
    val title: String
)

data class RecipeWithKeyIngredients(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipeName",
        entityColumn = "title",
        associateBy = Junction(RecipeKeyIngredientCrossRef::class)
    )
    val keyIngrediens: List<KeyIngredient>
)

@Entity
data class Steps(
    @PrimaryKey(autoGenerate = true)
    val stepId: Int,
    val stepText: String,
    val stepImage: String,
    val recipeName: String
    )

data class RecipeWithKeyIngredientsAndSteps(
    @Embedded val recipe: RecipeWithKeyIngredients,
    @Relation(
        entity = Steps::class,
        parentColumn = "recipeName",
        entityColumn = "recipeName"
    )
    val steps: List<Steps>
)

data class Favorite(
    val recipe: Recipe,
    val number: Int
)


data class Recipe2(
    val name: String,
    val image: String,
    val prepTime: String,
    val energy: String,
    val healthy: String,
    val information: String,
    val keyIngrediens: List<KeyIngredients2>,
    val stepss: List<stepss>
)
data class KeyIngredients2(
    val image: String,
    val title: String,
    val undertitle: Int,
    val recipeName: String
)


data class stepss(val stepText: String, @DrawableRes val stepImage: Int)
//this is for preview.
val Cake = Recipe2(
    name = "Cake",
    prepTime = "30 Min.",
    energy = "456 Cal",
    image = "lasagna",
    healthy = "6/10",
    information = "A freshly baked cake smothered in frosting makes an irresistible homemade dessert.",
    keyIngrediens = listOf(
        KeyIngredients2("tomato", "tomato", 4,"Cake"),
        KeyIngredients2("onion", "onion", 6,"Cake"),
        KeyIngredients2("garlic", "g garlic", 100,"Cake"),
        KeyIngredients2("spinach", "g spinach", 50,"Cake"),
        KeyIngredients2("carrot", "carrot", 3,"Cake"),
        KeyIngredients2("lentil", "g pasta", 250,"Cake")
    ),
    stepss = listOf(
        stepss(stepText = "Put the lemons in a blender and bltiz along with half of the sugar, half the ice cubes and water.",
            R.drawable.tomato
        ),
        stepss(stepText = "Strain the juice into a jug to get rid of any bits.", 0),
        stepss(stepText = "Put the lemon pulp back into the food processor. Add the rest of the sugar, ice cubes and water and blitz again.", 0),
        stepss(stepText = "Strain it into the jug with the first lot of juice and discard the pulp.", 0),
        stepss(stepText = "Serve with lots of ice", R.drawable.carrot)
    )

)