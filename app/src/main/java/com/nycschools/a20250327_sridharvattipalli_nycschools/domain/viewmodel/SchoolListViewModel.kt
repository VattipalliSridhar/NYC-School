package com.nycschools.a20250327_sridharvattipalli_nycschools.domain.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nycschools.a20250327_sridharvattipalli_nycschools.data.api.SchoolApi
import com.nycschools.a20250327_sridharvattipalli_nycschools.data.model.SchoolInfo
import com.nycschools.a20250327_sridharvattipalli_nycschools.data.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository
) : ViewModel() {

    private val _schools = MutableStateFlow<List<SchoolInfo>>(emptyList())
    val schools: StateFlow<List<SchoolInfo>> = _schools.asStateFlow()

    init {
        getSchoolList()
    }

    private fun getSchoolList() {
        viewModelScope.launch {
            try {
                val response = schoolRepository.getSchoolList()
                if (response.isSuccessful) {
                    _schools.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                Log.e("SchoolListViewModel", "Error fetching school list", e)
            }
        }
    }


}