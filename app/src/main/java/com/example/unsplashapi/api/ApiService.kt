package com.example.unsplashapi.api

import com.example.unsplashapi.model.PhotoDataList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Authorization: Client-ID Yme6ZcumIXpWryQ0DPc249CE0ua2Mxh66Y-4W2gPAAc")
    @GET("/photos/random?count=30")
    suspend fun getPhotos(): Response<PhotoDataList>
}