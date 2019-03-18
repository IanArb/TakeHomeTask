package com.ianarbuckle.codingproject.ui.carsdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ianarbuckle.codingproject.app.CodingProjectApp
import com.ianarbuckle.codingproject.ui.carsdetail.builder.CarsDetailsModule
import com.ianarbuckle.codingproject.ui.carsdetail.builder.DaggerCarsDetailsComponent
import com.ianarbuckle.codingproject.ui.carsdetail.presenter.CarsDetailPresenter
import com.ianarbuckle.codingproject.ui.carsdetail.view.CarsDetailsView
import kotlinx.android.synthetic.main.cars_detail_view.view.*
import javax.inject.Inject

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
class CarsDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var view: CarsDetailsView

    @Inject
    lateinit var presenter: CarsDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerCarsDetailsComponent.builder()
                .appComponent(CodingProjectApp.component)
                .carsDetailsModule(CarsDetailsModule(this))
                .build()
                .inject(this)

        setContentView(view.getView())

        setSupportActionBar(view.getView().toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.onCreate()
    }

}