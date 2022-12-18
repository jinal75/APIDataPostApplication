package com.example.apidatapostappication.API

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    const val IMAGE_URL = "https://newrhmode.embedinfosoft.com/"
    private const val BASE_URL = "https://newrhmode.embedinfosoft.com/api/"

    private var retrofit: Retrofit? = null
    private var retrofit2: Retrofit? = null
    var client: OkHttpClient? = null

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    fun setClient(authToken: String) {
        client = OkHttpClient.Builder().addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $authToken")
                .build()
            chain.proceed(newRequest)
        }).build()
    }

    fun getClient2(authToken: String): Retrofit? {
        setClient(authToken)
        if (retrofit2 == null) {
            retrofit2 = Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit2
    }

}
