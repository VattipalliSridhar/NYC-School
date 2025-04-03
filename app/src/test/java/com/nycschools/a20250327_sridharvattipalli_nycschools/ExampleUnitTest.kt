package com.nycschools.a20250327_sridharvattipalli_nycschools

import com.nycschools.a20250327_sridharvattipalli_nycschools.domain.viewmodel.SchoolListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainCoroutineDispatcher
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

@ExperimentalCoroutinesApi
class SchoolTest{
    private lateinit var viewModel: SchoolListViewModel

}