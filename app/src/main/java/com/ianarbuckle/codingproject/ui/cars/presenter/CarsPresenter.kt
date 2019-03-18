package com.ianarbuckle.codingproject.ui.cars.presenter

import com.ianarbuckle.codingproject.ui.cars.interactor.CarsInteractor
import com.ianarbuckle.codingproject.ui.cars.view.CarsView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
interface CarsPresenter {
    fun onCreate()
    fun onDestroy()
}

class DefaultCarsPresenter(private val view: CarsView, private val interactor: CarsInteractor) :
        CarsPresenter, CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate() {
        job = launch {
            view.showLoading()
            try {
                view.showLegend(interactor.fetchLegendInfo())
                view.showAvailableVechiles(interactor.fetchAvailableVendors())
            } catch (exception: Exception) {
                view.showErrorMessage()
                Timber.e("Error: %s", exception.message)
            } finally {
                view.hideLoading()
            }
        }
    }

    override fun onDestroy() {
        job.cancel()
    }
}