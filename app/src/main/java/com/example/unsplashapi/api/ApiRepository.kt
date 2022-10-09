package com.example.unsplashapi.api

import com.example.unsplashapi.model.PhotoDataList
import retrofit2.Response

class ApiRepository {

    suspend fun getPhotos(): Response<PhotoDataList> {
        return RetrofitInstance.api.getPhotos()
    }

}