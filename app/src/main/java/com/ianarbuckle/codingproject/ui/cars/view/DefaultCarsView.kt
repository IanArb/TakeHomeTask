package com.ianarbuckle.codingproject.ui.cars.view

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.VehRentalCore
import com.ianarbuckle.codingproject.data.VehVendorAvail
import com.ianarbuckle.codingproject.ui.cars.view.adapter.ParentCarsAdapter
import kotlinx.android.synthetic.main.cars_view.view.*
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
class DefaultCarsView(context: Context) : CarsView, ConstraintLayout(context) {

    lateinit var recyclerView: RecyclerView

    init {
        inflate(context, R.layout.cars_view, this)
        toolbar.apply {
            title = "Available Cars"
            setTitleTextColor(ContextCompat.getColor(context, R.color.colorWhite))
        }
    }

    override fun getView(): View = this

    override fun showLegend(legend: VehRentalCore) {
        val formatPickUpTime = formatDateTime(legend.pickUpDateTime)
        pickUpTime.text = formatPickUpTime
        pickUpLocation.text = legend.pickUpLocation.name

        val formatReturnTime = formatDateTime(legend.returnDateTime)
        returnTime.text = formatReturnTime
        returnLocation.text = legend.returnLocation.name
    }

    private fun formatDateTime(date: String): String {
        val dateTime = DateTime.parse(date)
        return dateTime.toString(DateTimeFormat.mediumDateTime())
    }

    override fun showAvailableVechiles(availableVechiles: List<VehVendorAvail>) {
        recyclerView = parentRecyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = ParentCarsAdapter(context, availableVechiles)
        }
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    override fun showErrorMessage() {
        Toast.makeText(context, "Error retrieving info", Toast.LENGTH_LONG).show()
    }
}