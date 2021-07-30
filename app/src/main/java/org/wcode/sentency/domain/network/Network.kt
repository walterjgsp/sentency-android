package org.wcode.sentency.domain.network

import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.wcode.sentency.BuildConfig
import org.wcode.sentency.core.Constants.HEADER_API_KEY
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(provideOkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(createInterceptor()).build()
}

private fun createInterceptor(): Interceptor {
    return Interceptor { chain ->
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .url(originalRequest.url)
            .addHeader(HEADER_API_KEY, BuildConfig.API_KEY)
            .method(originalRequest.method, originalRequest.body)
            .build()

        chain.proceed(newRequest)
    }
}

inline fun <reified T> provideApi(retrofit: Retrofit): T = retrofit.create(T::class.java)