package com.ianarbuckle.codingproject.ui.utils

import com.ianarbuckle.codingproject.data.*

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
object TestUtils {

    fun getAvailableVehicle(): VehAvail {
        val totalCharge = TotalCharge("EUR", "100", "100")
        val vehicle = Vehicle("true", "4", "435", "435", "4", "Automatic", "Petrol", "4", "Automatic", "image.jpg", VehMakeModel("Ford"))
        return VehAvail("Available", totalCharge, vehicle)
    }

    fun getListOfCars(): MutableList<Cars> {
        val listOfCars: MutableList<Cars> = ArrayList()

        val totalCharge = TotalCharge("EUR", "200.00", "200.00")
        val vehicle = Vehicle("", "4", "090", "090", "4", "",
                "Petrol", "4", "Automatic", "image.png", VehMakeModel("Ford Mondeo"))

        val listofVehAvail = mutableListOf<VehAvail>()
        val vehAvail = VehAvail("Available", totalCharge, vehicle)
        listofVehAvail.add(vehAvail)

        val listOfVehVendor = getAvailableVendors(listofVehAvail)

        val pickUpLocation = PickUpLocation("Las Vegas")
        val returnLocation = ReturnLocation("Las Vegas")
        val vehRentalCore = VehRentalCore("21-10-2004", "21-10-2004", pickUpLocation, returnLocation)
        val vehAvailRSCore = VehAvailRSCore(vehRentalCore, listOfVehVendor)
        val cars = Cars(vehAvailRSCore)

        listOfCars.add(cars)

        return listOfCars
    }

    fun getAvailableVendors(listofVehAvail: MutableList<VehAvail>): MutableList<VehVendorAvail> {
        val listOfVehVendor = mutableListOf<VehVendorAvail>()
        val vehVendorAvail = VehVendorAvail(listofVehAvail, Vendor("090", "Ford"))
        listOfVehVendor.add(vehVendorAvail)
        return listOfVehVendor
    }
}