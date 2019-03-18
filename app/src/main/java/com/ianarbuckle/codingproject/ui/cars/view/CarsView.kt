package com.ianarbuckle.codingproject.ui.cars.view

import android.view.View
import com.ianarbuckle.codingproject.data.VehRentalCore
import com.ianarbuckle.codingproject.data.VehVendorAvail

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
interface CarsView {
    fun getView(): View
    fun showLegend(legend: VehRentalCore)
    fun showAvailableVechiles(availableVechiles: List<VehVendorAvail>)
    fun showLoading()
    fun hideLoading()
    fun showErrorMessage()
}