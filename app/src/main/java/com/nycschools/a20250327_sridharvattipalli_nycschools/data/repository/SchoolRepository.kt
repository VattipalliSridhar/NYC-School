package com.nycschools.a20250327_sridharvattipalli_nycschools.data.repository

import com.nycschools.a20250327_sridharvattipalli_nycschools.data.api.SchoolApi
import com.nycschools.a20250327_sridharvattipalli_nycschools.data.model.SchoolInfo
import javax.inject.Inject

class SchoolRepository @Inject constructor(
    private val api: SchoolApi
) {

    suspend fun getSchoolList() = api.getSchoolInfo()
}