package com.ianarbuckle.codingproject.ui.carsdetail.interactor

import android.app.Activity
import com.ianarbuckle.codingproject.data.VehAvail

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
interface CarsDetailInteractor {
    fun getVehicle(): VehAvail
}

class DefaultCarsDetailInteractor(private val activity: Activity): CarsDetailInteractor {

    override fun getVehicle(): VehAvail = activity.intent.getParcelableExtra("vehicle")

}