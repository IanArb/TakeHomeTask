package com.ianarbuckle.codingproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ianarbuckle.codingproject.app.CodingProjectApp
import com.ianarbuckle.codingproject.ui.builder.DaggerHomeComponent
import com.ianarbuckle.codingproject.ui.builder.HomeModule
import com.ianarbuckle.codingproject.ui.presenter.HomePresenter
import com.ianarbuckle.codingproject.ui.view.HomeView
import javax.inject.Inject

/**
 * Created by Ian Arbuckle on 16/11/2018.
 *
 */
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: HomePresenter

    @Inject
    lateinit var view: HomeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerHomeComponent.builder()
                .appComponent(CodingProjectApp.component)
                .homeModule(HomeModule(this))
                .build()
                .inject(this)

        setContentView(view.getView())

        presenter.onCreate()
    }
}