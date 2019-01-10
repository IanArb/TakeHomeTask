package com.ianarbuckle.codingproject.ui.interactor

import com.ianarbuckle.codingproject.data.*

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
interface HomeInteractor {
    fun fetchCustomersWithinDistance(): List<Customer>
}