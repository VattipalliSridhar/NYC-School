package com.nycschools.a20250327_sridharvattipalli_nycschools.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nycschools.a20250327_sridharvattipalli_nycschools.data.model.SchoolInfo
import com.nycschools.a20250327_sridharvattipalli_nycschools.domain.viewmodel.SchoolListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolDetailScreen(
    schoolId: String,
    navController: NavController,
    viewModel: SchoolListViewModel = hiltViewModel()
) {
    val schools by viewModel.schools.collectAsState()

    val school = schools.find { it.dbn == schoolId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text ="School Details")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE), // Background color
                    titleContentColor = Color.White, // Title color
                    navigationIconContentColor = Color.White, // Icon color (if any)
                    actionIconContentColor = Color.White // Action icon color (if any)
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp() // Go back to previous screen
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (schools.isEmpty()) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        } else if (school != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                /*item {
                    Text(
                        text = "School Details",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }*/

                item { detailItem("School Name", school.school_name) }
                item { detailItem("DBN", school.dbn) }
                item { detailItem("Overview", school.overview_paragraph) }
                item { detailItem("Borough", school.borough) }
                item { detailItem("City", school.city) }
                item { detailItem("Neighborhood", school.neighborhood) }
                item { detailItem("Location", school.location) }
                item { detailItem("Phone Number", school.phone_number) }
                item { detailItem("School Email", school.school_email) }
                item { detailItem("Website", school.website) }
                item { detailItem("Accessibility", school.school_accessibility_description) }
                item { detailItem("Attendance Rate", school.attendance_rate) }
                item { detailItem("Total Students", school.total_students) }
                item { detailItem("Grades", school.grades2018) }
                item { detailItem("Sports", school.school_sports) }
                item { detailItem("Extracurricular Activities", school.extracurricular_activities) }
                item { detailItem("Academic Opportunities 1", school.academicopportunities1) }
                item { detailItem("Academic Opportunities 2", school.academicopportunities2) }
                item { detailItem("Program", school.program1) }
                item { detailItem("Requirement 1", school.requirement1_1) }
                item { detailItem("Requirement 2", school.requirement2_1) }
                item { detailItem("Requirement 3", school.requirement3_1) }
                item { detailItem("Requirement 4", school.requirement4_1) }
                item { detailItem("Requirement 5", school.requirement5_1) }
                item { detailItem("Subway", school.subway) }
                item { detailItem("Bus", school.bus) }
                item { detailItem("Offer Rate", school.offer_rate1) }
                item { detailItem("Interest", school.interest1) }
                item { detailItem("Method", school.method1) }
                item { detailItem("Latitude", school.latitude) }
                item { detailItem("Longitude", school.longitude) }
                item { detailItem("Final Grades", school.finalgrades) }
                item { detailItem("Admissions Priority 1", school.admissionspriority11) }
                item { detailItem("Admissions Priority 2", school.admissionspriority21) }
                item { detailItem("Admissions Priority 3", school.admissionspriority31) }
            }
        } else {
            Text(
                text = "School not found.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}


@Composable
fun detailItem(label: String, value: String?) {
    if (!value.isNullOrBlank()) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge.copy(color = Color.Gray)
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 4.dp)
            )
            Divider(
                color = Color.LightGray,
                thickness = 0.5.dp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
