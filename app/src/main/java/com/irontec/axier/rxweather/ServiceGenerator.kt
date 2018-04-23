package com.irontec.axier.rxweather

import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by axier on 13/3/17.
 */

object ServiceGenerator {

    private val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)

    private val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.URL_ENDPOINT)
            .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
            )
            .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        builder.client(httpClient.build())
        val retrofit = builder.build()
        return retrofit.create(serviceClass)
    }
}
