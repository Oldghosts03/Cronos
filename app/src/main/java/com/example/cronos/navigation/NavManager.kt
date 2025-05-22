package com.example.cronos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cronos.viewModels.CronometroViewModel
import com.example.cronos.viewModels.CronosViewModel
import com.example.cronos.views.AddView
import com.example.cronos.views.EditView
import com.example.cronos.views.HomeView

@Composable
fun NavManager(cronometroVM: CronometroViewModel, cronosVM: CronosViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController, cronosVM)
        }
        composable("AddView"){
            AddView(navController,cronometroVM, cronosVM)
        }
        composable("EditView"){
            EditView(navController)
        }
    }
}