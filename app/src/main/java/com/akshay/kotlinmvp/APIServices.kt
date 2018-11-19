package com.akshay.kotlinmvp

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIServices {

    @FormUrlEncoded
    @POST("createuser")
    public fun createUser(
            @Field("first_name") first_name: String,
            @Field("last_name") last_name: String,
            @Field("mobile_number") mobile_number: String,
            @Field("email_address") email_address: String,
    @Field("password") password: String
    ): Observable<Result.Registration>

    companion object {
        fun create(): APIServices {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://192.168.0.7/LumenApps/DHomeServices/public/")
                    .build()

            return retrofit.create(APIServices::class.java)
        }
    }
}