package com.ianarbuckle.codingproject.network

import com.ianarbuckle.codingproject.data.Cars
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
interface APIService {

    @GET("ctabe/cars.json")
    fun fetchCars(): Deferred<MutableList<Cars>>

}