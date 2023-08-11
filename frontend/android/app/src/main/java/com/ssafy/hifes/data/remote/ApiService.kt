package com.ssafy.hifes.data.remote

import com.ssafy.hifes.data.model.ErrorResponse
import com.ssafy.hifes.data.model.LoginResponse
import com.ssafy.hifes.data.model.NormalUserSignUpDto
import com.ssafy.hifes.util.network.NetworkResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
    @POST("/normal/login")
    suspend fun login(@Query("accessToken") accessToken: String): NetworkResponse<LoginResponse, ErrorResponse>



    @Multipart
    @POST("/normal/signUp")
    suspend fun signUp(
        @Part("normalUserSignUpDto") normalUserSignUpDto: RequestBody,
        @Part image: MultipartBody.Part
    ): NetworkResponse<LoginResponse, ErrorResponse>
}