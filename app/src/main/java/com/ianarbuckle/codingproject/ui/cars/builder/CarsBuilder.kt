package com.ianarbuckle.codingproject.ui.cars.builder

import android.content.Context
import com.ianarbuckle.codingproject.app.builder.AppComponent
import com.ianarbuckle.codingproject.network.APIService
import com.ianarbuckle.codingproject.ui.cars.CarsActivity
import com.ianarbuckle.codingproject.ui.cars.interactor.CarsInteractor
import com.ianarbuckle.codingproject.ui.cars.interactor.DefaultCarsInteractor
import com.ianarbuckle.codingproject.ui.cars.presenter.CarsPresenter
import com.ianarbuckle.codingproject.ui.cars.presenter.DefaultCarsPresenter
import com.ianarbuckle.codingproject.ui.cars.repository.CarsRepository
import com.ianarbuckle.codingproject.ui.cars.repository.DefaultCarsRepository
import com.ianarbuckle.codingproject.ui.cars.view.CarsView
import com.ianarbuckle.codingproject.ui.cars.view.DefaultCarsView
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CarsScope

@Module
class CarsModule(private val activity: CarsActivity) {

    @CarsScope
    @Provides
    fun provideContext(): Context = activity

    @CarsScope
    @Provides
    fun provideView(context: Context): CarsView = DefaultCarsView(context)

    @CarsScope
    @Provides
    fun provideInteractor(repository: CarsRepository): CarsInteractor = DefaultCarsInteractor(repository)

    @CarsScope
    @Provides
    fun provideRepository(service: APIService): CarsRepository = DefaultCarsRepository(service)

    @CarsScope
    @Provides
    fun providePresenter(view: CarsView, interactor: CarsInteractor): CarsPresenter =
            DefaultCarsPresenter(view, interactor)

}

@CarsScope
@Component(modules = [CarsModule::class], dependencies = [AppComponent::class])
interface CarsComponent {
    fun inject(activity: CarsActivity)
}