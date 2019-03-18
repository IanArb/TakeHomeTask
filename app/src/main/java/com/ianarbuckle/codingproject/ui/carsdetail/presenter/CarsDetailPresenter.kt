package com.ianarbuckle.codingproject.ui.carsdetail.presenter

import com.ianarbuckle.codingproject.ui.carsdetail.interactor.CarsDetailInteractor
import com.ianarbuckle.codingproject.ui.carsdetail.view.CarsDetailsView

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */

interface CarsDetailPresenter {
    fun onCreate()
}

class DefaultCarsDetailPresenter(private val view: CarsDetailsView, private val interactor: CarsDetailInteractor)
    : CarsDetailPresenter {

    override fun onCreate() {
        view.showVehicle(interactor.getVehicle())
    }

}
