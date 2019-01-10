package com.ianarbuckle.codingproject.ui.presenter

import com.ianarbuckle.codingproject.data.Customer
import com.ianarbuckle.codingproject.ui.interactor.HomeInteractor
import com.ianarbuckle.codingproject.ui.view.HomeView
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Ian Arbuckle on 10/01/2019.
 *
 */
class HomePresenterTest {

    private lateinit var presenter: HomePresenter

    @Mock
    private lateinit var interactor: HomeInteractor

    @Mock
    private lateinit var view: HomeView

    @Before
    fun setup() {
        initMocks(this)
        presenter = DefaultHomePresenter(view, interactor)
    }

    @Test
    fun `verify on create should show results`() {
        val list = ArrayList<Customer>().apply {
            add(Customer(1, "Ian", 52.986375, -6.043701))
        }
        `when`(interactor.fetchCustomersWithinDistance()).thenReturn(list)

        presenter.onCreate()

        verify(view, times(1)).showResults(ArgumentMatchers.anyList())
    }


}