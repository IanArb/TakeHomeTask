package com.ianarbuckle.codingproject.app

import android.app.Application
import com.ianarbuckle.codingproject.app.builder.AppComponent
import com.ianarbuckle.codingproject.app.builder.AppModule
import com.ianarbuckle.codingproject.app.builder.DaggerAppComponent

/**
 * Created by Ian Arbuckle on 16/11/2018.
 *
 */
class CodingProjectApp : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        component.inject(this)
    }
}