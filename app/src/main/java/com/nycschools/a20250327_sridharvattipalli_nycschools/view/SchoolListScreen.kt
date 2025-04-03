package com.nycschools.a20250327_sridharvattipalli_nycschools.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nycschools.a20250327_sridharvattipalli_nycschools.data.model.SchoolInfo
import com.nycschools.a20250327_sridharvattipalli_nycschools.domain.viewmodel.SchoolListViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolListScreen(
    navController: NavController,
    viewModel: SchoolListViewModel = hiltViewModel()
) {
    val schools by viewModel.schools.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "NYC Schools")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE), // Background color
                    titleContentColor = Color.White, // Title color
                    navigationIconContentColor = Color.White, // Icon color (if any)
                    actionIconContentColor = Color.White // Action icon color (if any)
                )
            )
        }
    ) { paddingValues ->

        if (schools.isEmpty()) {
            // Show loading indicator while data is loading
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Loading...",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxSize().align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(schools) { school ->
                    SchoolCard(school = school, navController = navController)
                }
            }
        }
    }
}


@Composable
fun SchoolCard(school: SchoolInfo, navController: NavController) {
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Navigate to the SchoolDetailScreen
                navController.navigate("school_detail/${school.dbn}")
            }
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        
        Column(modifier = Modifier
            .padding(16.dp)) {
            
            Text(text = "School Name: ${school.school_name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Location Name: ${school.location}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "School Id: ${school.dbn}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Total Students: ${school.total_students}", style = MaterialTheme.typography.bodyMedium)
            
        }
        
        
    }

}
