package com.ianarbuckle.codingproject.ui.cars.repository

import com.ianarbuckle.codingproject.data.Cars
import com.ianarbuckle.codingproject.network.APIService

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
interface CarsRepository {
    suspend fun fetchCars(): MutableList<Cars>
}

class DefaultCarsRepository(private val service: APIService) : CarsRepository {

    override suspend fun fetchCars(): MutableList<Cars> = service.fetchCars().await()

}