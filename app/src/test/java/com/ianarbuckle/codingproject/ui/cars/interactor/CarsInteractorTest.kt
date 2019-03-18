package com.ianarbuckle.codingproject.ui.cars.interactor

import com.ianarbuckle.codingproject.data.*
import com.ianarbuckle.codingproject.ui.cars.repository.CarsRepository
import com.ianarbuckle.codingproject.ui.utils.TestUtils.getListOfCars
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when` as whenever
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
class CarsInteractorTest {

    private lateinit var interactor: CarsInteractor

    @Mock
    private lateinit var repository: CarsRepository

    @Before
    fun setup() {
        initMocks(this)

        interactor = DefaultCarsInteractor(repository)
    }

    @Test
    fun `verify when fetching available vendors it should return list of available vendors`() {
        runBlocking {
            val listOfCars: MutableList<Cars> = getListOfCars()

            whenever(repository.fetchCars()).thenReturn(listOfCars)

            interactor.fetchAvailableVendors()

            verify(repository, times(1)).fetchCars()
        }
    }


}