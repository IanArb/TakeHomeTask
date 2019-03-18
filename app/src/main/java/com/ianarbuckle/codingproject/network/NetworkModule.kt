package com.ianarbuckle.codingproject.network

import android.content.Context
import com.ianarbuckle.codingproject.app.builder.AppScope
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */

@Module
class NetworkModule {

    companion object {
        const val CACHE_SIZE: Long = 5 * 1024 * 1024
        const val TIMEOUT: Long = 10
        const val ENDPOINT = "http://www.cartrawler.com/"
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor, cache: Cache): OkHttpClient =
        OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build()

    @AppScope
    @Provides
    fun provideInterceptor(): Interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.d(it) })
            .apply { level = HttpLoggingInterceptor.Level.BASIC }

    @AppScope
    @Provides
    fun provideCache(context: Context): Cache = Cache(context.cacheDir, CACHE_SIZE)

    @AppScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @AppScope
    @Provides
    fun provideService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)

}
