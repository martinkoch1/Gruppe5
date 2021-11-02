package com.example.sundmadnepal

import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){

        HomeScreenScaffold(navController)
}

@Composable
private fun HomeScreenScaffold(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ) {

    }
}

@Composable
private fun NepalToolBar(navController: NavController){
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ){
        NepalToolButton(
            navController,
            labelText = "Home",
            route = "HomeScreen",
            selected = true,
            icon = Icons.Default.Home
        )
        NepalToolButton(
            navController,
            labelText = "Recipes",
            route = "RecipeScreen",
            selected = false,
            icon = Icons.Default.Build
        )
        NepalToolButton(
            navController,
            labelText = "HealthInfo",
            route = "HealthInfoscreen",
            icon = Icons.Default.Favorite,
            selected = false
        )
        NepalToolButton(
            navController,
            labelText = "Profile",
            route = "ProfileScreen",
            selected = false,
            icon = Icons.Default.Person

        )
    }
}
@Composable
private fun RowScope.NepalToolButton(
    navController: NavController,
    selected: Boolean,
    route: String,
    icon: ImageVector,
    labelText: String,
){
    BottomNavigationItem(
        selected = selected,
        onClick = {
            navController.navigate(route)
                  },
        icon = {
            Icon(
                icon,
                contentDescription = null,
            )
        },
        label = {
            Text(labelText)
        }
    )
}

@Composable
private fun HomeScreenContent(){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){

    }
}

