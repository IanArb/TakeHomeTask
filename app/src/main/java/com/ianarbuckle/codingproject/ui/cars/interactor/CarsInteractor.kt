package com.ianarbuckle.codingproject.ui.cars.interactor

import com.ianarbuckle.codingproject.data.VehRentalCore
import com.ianarbuckle.codingproject.data.VehVendorAvail
import com.ianarbuckle.codingproject.ui.cars.repository.CarsRepository

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
interface CarsInteractor {
    suspend fun fetchAvailableVendors(): List<VehVendorAvail>
    suspend fun fetchLegendInfo(): VehRentalCore
}

class DefaultCarsInteractor(private val repository: CarsRepository) : CarsInteractor {

    override suspend fun fetchAvailableVendors(): List<VehVendorAvail> = repository.fetchCars()[0].vehAvailRSCore.vehVendorAvails

    override suspend fun fetchLegendInfo(): VehRentalCore = repository.fetchCars()[0].vehAvailRSCore.vehRentalCore

}