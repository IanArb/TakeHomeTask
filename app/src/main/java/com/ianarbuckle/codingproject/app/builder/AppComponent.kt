package com.ianarbuckle.codingproject.app.builder

import com.ianarbuckle.codingproject.app.CodingProjectApp
import com.ianarbuckle.codingproject.network.APIService
import com.ianarbuckle.codingproject.network.NetworkModule
import dagger.Component

/**
 * Created by Ian Arbuckle on 16/11/2018.
 *
 */
@AppScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: CodingProjectApp)
    fun service(): APIService
}