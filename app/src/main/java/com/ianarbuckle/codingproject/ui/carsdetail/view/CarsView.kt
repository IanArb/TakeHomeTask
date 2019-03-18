package com.ianarbuckle.codingproject.ui.carsdetail.view

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.VehAvail
import kotlinx.android.synthetic.main.cars_detail_view.view.*
import com.ianarbuckle.codingproject.extension.provideImage

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
interface CarsDetailsView {
    fun getView(): View
    fun showVehicle(vehAvail: VehAvail)
}

class DefaultCarsDetailView(context: Context) : CarsDetailsView, ConstraintLayout(context) {

    init {
        inflate(context, R.layout.cars_detail_view, this)
    }

    override fun getView(): View = this

    override fun showVehicle(vehAvail: VehAvail) {
        setToolbarTitle(vehAvail.vehicle.vehMakeModel.name)
        setImage(vehAvail.vehicle.pictureURL)
        showContent(vehAvail)
    }

    private fun setToolbarTitle(name: String) {
        toolbar.apply {
            title = name
            setTitleTextColor(ContextCompat.getColor(context, R.color.colorWhite))
        }
    }

    private fun setImage(url: String) {
        carImage.provideImage(context, url)
    }

    private fun showContent(vehAvail: VehAvail) {
        transmissionType.text = context.getString(R.string.transmission_type_text, vehAvail.vehicle.transmissionType)
        price.text = context.getString(R.string.price_text, vehAvail.totalCharge.currencyCode, vehAvail.totalCharge.rateTotalAmount)
        carName.text = context.getString(R.string.model_type_text, vehAvail.vehicle.vehMakeModel.name)
        fuelType.text = context.getString(R.string.fuel_type_text, vehAvail.vehicle.fuelType)
        passengerQuantity.text = context.getString(R.string.passenger_quantity_text, vehAvail.vehicle.passengerQuantity)
    }
}