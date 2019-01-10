package com.ianarbuckle.codingproject.ui.interactor

import android.app.Activity
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.Customer
import com.ianarbuckle.codingproject.parser.GsonParser
import com.ianarbuckle.codingproject.parser.GsonParserImpl

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
class DefaultHomeInteractor(private val activity: Activity, private val parser: GsonParser) : HomeInteractor {
    
    companion object {
        private const val ORIGIN_LATITUDE = 53.339428
        private const val ORIGIN_LONGITUDE = -6.257664
        private const val DISTANCE = 100.0 //km
    }

    private var orderedList = ArrayList<Customer>()

    //Formula -- Haversine Formula https://en.wikipedia.org/wiki/Haversine_formula
    override fun fetchCustomersWithinDistance(): List<Customer> {
        val list = fetchCustomers()

        val earthRadius = 6371

        list.forEach {
            val distanceLatitude = toRadians(it.latitude - ORIGIN_LATITUDE)
            val distanceLongitude = toRadians(it.longitude - ORIGIN_LONGITUDE)

            val a = Math.sin(distanceLatitude/2) * Math.sin(distanceLatitude/2) +
                    Math.sin(distanceLongitude/2) * Math.sin(distanceLongitude/2) * Math.cos(ORIGIN_LATITUDE) * Math.cos(it.latitude)
            val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))

            if(earthRadius * c <= DISTANCE) {
                orderedList.add(it)
            }
        }

        return orderedList.sortedBy { it.userId }
    }

    private fun fetchCustomers(): List<Customer> {
        val json = activity.resources.openRawResource(R.raw.customers).bufferedReader().use { it.readText() }
        return parser.parseJson(json)
    }

    private fun toRadians(degree: Double) = degree * (Math.PI/100)
}