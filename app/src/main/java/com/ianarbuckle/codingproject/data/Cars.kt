package com.ianarbuckle.codingproject.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ian Arbuckle on 10/01/2019.
 *
 */
data class Customer(@SerializedName("user_id") val userId: Int, val name: String, val latitude: Double, val longitude: Double)

data class Customers(val customers: List<Customer>)

data class Cars(
    @SerializedName("VehAvailRSCore") val vehAvailRSCore: VehAvailRSCore
)

data class VehAvailRSCore(
        @SerializedName("VehRentalCore") val vehRentalCore: VehRentalCore,
        @SerializedName("VehVendorAvails") val vehVendorAvails: List<VehVendorAvail>
)

data class VehVendorAvail(
        @SerializedName("VehAvails") val vehAvails: List<VehAvail>,
        @SerializedName("Vendor") val vendor: Vendor
)

@Parcelize
data class VehAvail(
        @SerializedName("@Status") val status : String,
        @SerializedName("TotalCharge") val totalCharge: TotalCharge,
        @SerializedName("Vehicle") val vehicle: Vehicle
) : Parcelable

@Parcelize
data class Vehicle(
        @SerializedName("@AirConditionInd") val airConditionInd : String,
        @SerializedName("@BaggageQuantity") val baggageQuantity : String,
        @SerializedName("@Code") val code : String,
        @SerializedName("@CodeContext") val codeContext : String,
        @SerializedName("@DoorCount") val doorCount : String,
        @SerializedName("@DriveType") val driveType : String,
        @SerializedName("@FuelType") val fuelType : String,
        @SerializedName("@PassengerQuantity") val passengerQuantity : String,
        @SerializedName("@TransmissionType") val transmissionType : String,
        @SerializedName("PictureURL") val pictureURL: String,
        @SerializedName("VehMakeModel") val vehMakeModel: VehMakeModel
) : Parcelable

@Parcelize
data class VehMakeModel(
    @SerializedName("@Name") val name : String
) : Parcelable

@Parcelize
data class TotalCharge(
        @SerializedName("@CurrencyCode") val currencyCode : String,
        @SerializedName("@EstimatedTotalAmount") val estimatedTotalAmount : String,
        @SerializedName("@RateTotalAmount") val rateTotalAmount : String
) : Parcelable

data class Vendor(
        @SerializedName("@Code") val code : String,
        @SerializedName("@Name") val name : String
)

data class VehRentalCore(
        @SerializedName("@PickUpDateTime") val pickUpDateTime : String,
        @SerializedName("@ReturnDateTime") val returnDateTime : String,
        @SerializedName("PickUpLocation") val pickUpLocation: PickUpLocation,
        @SerializedName("ReturnLocation") val returnLocation: ReturnLocation
)

data class PickUpLocation(
        @SerializedName("@Name") val name : String
)

data class ReturnLocation(
    @SerializedName("@Name") val name : String
)