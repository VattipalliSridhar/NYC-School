package com.nycschools.a20250327_sridharvattipalli_nycschools.view.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nycschools.a20250327_sridharvattipalli_nycschools.view.SchoolDetailScreen
import com.nycschools.a20250327_sridharvattipalli_nycschools.view.SchoolListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "school_list"
    ) {
        composable("school_list") {
            SchoolListScreen(navController)
        }
        composable("school_detail/{schoolId}") { backStackEntry ->
            val schoolId = backStackEntry.arguments?.getString("schoolId") ?: ""
            SchoolDetailScreen(schoolId,navController)
        }
    }
}
