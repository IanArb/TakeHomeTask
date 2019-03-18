package com.ianarbuckle.codingproject.ui.cars.presenter

import com.ianarbuckle.codingproject.ui.cars.interactor.CarsInteractor
import com.ianarbuckle.codingproject.ui.cars.view.CarsView
import com.ianarbuckle.codingproject.ui.utils.TestUtils.getListOfCars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
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
class CarsPresenterTest {

    private lateinit var presenter: CarsPresenter

    @Mock
    private lateinit var interactor: CarsInteractor

    @Mock
    private lateinit var view: CarsView

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        initMocks(this)
        presenter = DefaultCarsPresenter(view, interactor)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        presenter.onDestroy()
    }

    @Test
    fun `verify that when cars is retrieved it should show legend and available vehicles`() {
        runBlocking {
            val vehVendorAvails = getListOfCars()[0].vehAvailRSCore.vehVendorAvails
            val vehRentalCore = getListOfCars()[0].vehAvailRSCore.vehRentalCore
            whenever(interactor.fetchAvailableVendors()).thenReturn(vehVendorAvails)
            whenever(interactor.fetchLegendInfo()).thenReturn(vehRentalCore)

            presenter.onCreate()

            verify(view, times(1)).showLegend(vehRentalCore)
            verify(view, times(1)).showAvailableVechiles(vehVendorAvails)
            verify(view, times(1)).hideLoading()
        }
    }

    @Test
    fun `verify that when list of vendors or legend is null should show error message`() {
        presenter.onCreate()

        verify(view, times(1)).showErrorMessage()
    }

}