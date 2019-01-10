package com.ianarbuckle.codingproject.ui.builder

import com.ianarbuckle.codingproject.app.builder.AppComponent
import com.ianarbuckle.codingproject.ui.HomeActivity
import dagger.Component

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
@HomeScope
@Component(modules = [HomeModule::class], dependencies = [AppComponent::class])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}