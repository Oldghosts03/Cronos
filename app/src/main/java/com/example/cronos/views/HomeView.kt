package com.example.cronos.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cronos.components.CronoCards
import com.example.cronos.components.FloatButton
import com.example.cronos.components.MainTitle
import com.example.cronos.components.formatTiempo
import com.example.cronos.model.Cronos
import com.example.cronos.viewModels.CronosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, cronosVM: CronosViewModel){
    Scaffold(
        topBar={
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "Crono App")},
                colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }, floatingActionButton = {
            FloatButton{
                navController.navigate("AddView")
            }
        }
    ){
        ContentHomeView(it,navController, cronosVM)
    }
}
@Composable
fun ContentHomeView(it: PaddingValues, navController: NavController, cronosVM: CronosViewModel){
    Column(
        modifier = Modifier.padding(it)
    ){
        val cronoList:List<Cronos> by cronosVM.cronosList.collectAsState()
        LazyColumn {
            items(cronoList){item->
                CronoCards(item.title, formatTiempo(item.crono)){}
            }
        }
    }
}