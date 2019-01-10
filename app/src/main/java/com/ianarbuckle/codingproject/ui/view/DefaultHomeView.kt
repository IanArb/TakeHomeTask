package com.ianarbuckle.codingproject.ui.view

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.*
import com.ianarbuckle.codingproject.ui.view.adapter.HomeAdapter
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.home_view.view.*
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
class DefaultHomeView(context: Context) : ConstraintLayout(context), HomeView {

    init {
        inflate(context, R.layout.home_view, this )
    }

    override fun getView() = this

    override fun showResults(customers: List<Customer>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = HomeAdapter(customers)
        }
    }
}