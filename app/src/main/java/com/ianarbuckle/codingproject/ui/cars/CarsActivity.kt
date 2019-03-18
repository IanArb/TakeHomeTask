package com.ianarbuckle.codingproject.ui.cars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ianarbuckle.codingproject.app.CodingProjectApp
import com.ianarbuckle.codingproject.ui.cars.builder.CarsModule
import com.ianarbuckle.codingproject.ui.cars.builder.DaggerCarsComponent
import com.ianarbuckle.codingproject.ui.cars.presenter.CarsPresenter
import com.ianarbuckle.codingproject.ui.cars.view.CarsView
import javax.inject.Inject

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
class CarsActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: CarsPresenter

    @Inject
    lateinit var view: CarsView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerCarsComponent.builder()
                .appComponent(CodingProjectApp.component)
                .carsModule(CarsModule(this))
                .build()
                .inject(this)

        setContentView(view.getView())

        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}