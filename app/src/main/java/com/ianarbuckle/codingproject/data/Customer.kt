package com.ianarbuckle.codingproject.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Ian Arbuckle on 10/01/2019.
 *
 */
data class Customer(@SerializedName("user_id") val userId: Int, val name: String, val latitude: Double, val longitude: Double)

data class Customers(val customers: List<Customer>)