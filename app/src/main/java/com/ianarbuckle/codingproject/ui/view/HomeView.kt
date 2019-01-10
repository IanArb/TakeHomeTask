package com.ianarbuckle.codingproject.ui.view

import android.view.View
import com.ianarbuckle.codingproject.data.*
import io.reactivex.Observable

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
interface HomeView {
    fun getView(): View
    fun showResults(customers: List<Customer>)
}