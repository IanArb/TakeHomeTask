package com.ianarbuckle.codingproject.ui.carsdetail.builder

import android.content.Context
import com.ianarbuckle.codingproject.app.builder.AppComponent
import com.ianarbuckle.codingproject.ui.carsdetail.CarsDetailActivity
import com.ianarbuckle.codingproject.ui.carsdetail.interactor.CarsDetailInteractor
import com.ianarbuckle.codingproject.ui.carsdetail.interactor.DefaultCarsDetailInteractor
import com.ianarbuckle.codingproject.ui.carsdetail.presenter.CarsDetailPresenter
import com.ianarbuckle.codingproject.ui.carsdetail.presenter.DefaultCarsDetailPresenter
import com.ianarbuckle.codingproject.ui.carsdetail.view.CarsDetailsView
import com.ianarbuckle.codingproject.ui.carsdetail.view.DefaultCarsDetailView
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CarsDetailsScope

@Module
class CarsDetailsModule(private val activity: CarsDetailActivity) {

    @CarsDetailsScope
    @Provides
    fun provideContext(): Context = activity

    @CarsDetailsScope
    @Provides
    fun provideView(context: Context): CarsDetailsView = DefaultCarsDetailView(context)

    @CarsDetailsScope
    @Provides
    fun provideInteractor(): CarsDetailInteractor = DefaultCarsDetailInteractor(activity)

    @CarsDetailsScope
    @Provides
    fun providePresenter(view: CarsDetailsView, interactor: CarsDetailInteractor): CarsDetailPresenter
            = DefaultCarsDetailPresenter(view, interactor)

}

@CarsDetailsScope
@Component(modules = [CarsDetailsModule::class], dependencies = [AppComponent::class])
interface CarsDetailsComponent {
    fun inject(activity: CarsDetailActivity)
}