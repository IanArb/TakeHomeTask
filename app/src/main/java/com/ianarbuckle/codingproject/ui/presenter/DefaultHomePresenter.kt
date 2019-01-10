package com.ianarbuckle.codingproject.ui.presenter

import com.ianarbuckle.codingproject.ui.interactor.HomeInteractor
import com.ianarbuckle.codingproject.ui.view.HomeView

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
class DefaultHomePresenter(private val view: HomeView, private val interactor: HomeInteractor) : HomePresenter {

    override fun onCreate() {
        view.showResults(interactor.fetchCustomersWithinDistance())
    }
}