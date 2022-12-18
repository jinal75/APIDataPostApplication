package com.example.apidatapostappication.API


import com.example.apidatapostappication.utils.ApiResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIServices {
    //************Comman*************
    @FormUrlEncoded
    @POST("login")
    fun
    //can11@gmail.com
    //Admin@404
            login(
        @Field("Email") Email: String?,
        @Field("password") password: String?,
        @Field("NotificationToken") NotificationToken: String?,
        @Field("PrefferedLangauge") PrefferedLangauge: String?,
    ): Call<ApiResponse?>?

    @FormUrlEncoded
    @POST("degreelist")
    fun degreelist(
        @Field("PrefferedLangauge") PrefferedLangauge: String?,
    ): Call<ApiResponse?>?

    @FormUrlEncoded
    @POST("skilllist")
    fun skilllist(
        @Field("PrefferedLangauge") PrefferedLangauge: String?,
    ): Call<ApiResponse?>?

}