package com.apsel.mipppdeli.routes

import com.apsel.mipppdeli.models.ResponseHttp
import com.apsel.mipppdeli.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersRoutes {

    @POST("users/create")
    fun register(@Body user: User): Call<ResponseHttp>



}