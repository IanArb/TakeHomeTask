package com.ianarbuckle.codingproject.app.builder

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Ian Arbuckle on 16/11/2018.
 *
 */
@Module
class AppModule(private val application: Application) {

    @AppScope
    @Provides
    fun provideContext(): Context = application

}