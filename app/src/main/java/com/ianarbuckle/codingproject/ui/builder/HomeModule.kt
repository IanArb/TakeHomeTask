package com.ianarbuckle.codingproject.ui.builder

import android.content.Context
import com.ianarbuckle.codingproject.parser.GsonParser
import com.ianarbuckle.codingproject.ui.HomeActivity
import com.ianarbuckle.codingproject.ui.interactor.DefaultHomeInteractor
import com.ianarbuckle.codingproject.ui.interactor.HomeInteractor
import com.ianarbuckle.codingproject.ui.presenter.DefaultHomePresenter
import com.ianarbuckle.codingproject.ui.presenter.HomePresenter
import com.ianarbuckle.codingproject.ui.view.DefaultHomeView
import com.ianarbuckle.codingproject.ui.view.HomeView
import com.ianarbuckle.codingproject.parser.GsonParserImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
@Module
class HomeModule(private val activity: HomeActivity) {

    @HomeScope
    @Provides
    fun provideContext(): Context = activity

    @HomeScope
    @Provides
    fun provideView(context: Context): HomeView = DefaultHomeView(context)

    @HomeScope
    @Provides
    fun provideInteractor(parser: GsonParser): HomeInteractor = DefaultHomeInteractor(activity, parser)

    @HomeScope
    @Provides
    fun provideParser(): GsonParser = GsonParserImpl()

    @HomeScope
    @Provides
    fun providePresenter(view: HomeView, interactor: HomeInteractor): HomePresenter = DefaultHomePresenter(view, interactor)
}