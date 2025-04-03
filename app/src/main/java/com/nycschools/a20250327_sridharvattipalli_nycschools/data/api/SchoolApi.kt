package com.nycschools.a20250327_sridharvattipalli_nycschools.data.api

import com.nycschools.a20250327_sridharvattipalli_nycschools.data.model.SchoolInfo
import retrofit2.Response
import retrofit2.http.GET

interface SchoolApi {
    @GET("resource/s3k6-pzi2.json/")
    suspend fun getSchoolInfo(): Response<List<SchoolInfo>>
}