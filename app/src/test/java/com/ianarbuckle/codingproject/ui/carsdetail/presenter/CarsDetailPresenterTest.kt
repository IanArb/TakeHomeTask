package com.ianarbuckle.codingproject.ui.carsdetail.presenter

import com.ianarbuckle.codingproject.ui.carsdetail.interactor.CarsDetailInteractor
import com.ianarbuckle.codingproject.ui.carsdetail.view.CarsDetailsView
import com.ianarbuckle.codingproject.ui.utils.TestUtils.getAvailableVehicle
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
class CarsDetailPresenterTest {

    private lateinit var presenter: CarsDetailPresenter

    @Mock
    private lateinit var interactor: CarsDetailInteractor

    @Mock
    private lateinit var view: CarsDetailsView

    @Before
    fun setup() {
        initMocks(this)
        presenter = DefaultCarsDetailPresenter(view, interactor)
    }

    @Test
    fun `verify that onCreate shows vehicle`() {
        `when`(interactor.getVehicle()).thenReturn(getAvailableVehicle())

        presenter.onCreate()

        verify(view, times(1)).showVehicle(getAvailableVehicle())
        verify(interactor, times(1)).getVehicle()
    }
}