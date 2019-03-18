package com.ianarbuckle.codingproject.ui.cars.repository

import com.ianarbuckle.codingproject.data.Cars
import com.ianarbuckle.codingproject.network.APIService
import kotlinx.coroutines.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
@Suppress("DeferredResultUnused")
class CarsRepositoryTest {

    private lateinit var repository: CarsRepository

    @Mock
    private lateinit var service: APIService

    @Before
    fun setup() {
        initMocks(this)
        repository = DefaultCarsRepository(service)
    }

    @Test
    fun `verify that repository calls service to fetch cars`() {
        runBlocking {
            val cars: MutableList<Cars> = ArrayList()

            `when`(service.fetchCars()).thenReturn(GlobalScope.async { cars })
            repository.fetchCars()
            verify(service, times(1)).fetchCars()
        }

    }
}