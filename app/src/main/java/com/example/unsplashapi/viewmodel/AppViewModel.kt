package com.example.unsplashapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unsplashapi.api.ApiRepository
import com.example.unsplashapi.model.NeededPhotoData
import com.example.unsplashapi.model.NeededPhotoDataList
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {

    private val repository = ApiRepository()
    private val neededPhotoDataList = NeededPhotoDataList()
    val processedData = MutableLiveData<NeededPhotoDataList>()
    var clickedPhotoFullUrl = String()

    @OptIn(DelicateCoroutinesApi::class)
    fun getPhotos() {
        GlobalScope.launch {
            val response = repository.getPhotos()
            Log.d("response", response.toString())
            response.body().let { allPhotos ->
                if (allPhotos != null) {
                    for (photo in allPhotos) {
                        val fullUrl = photo.urls.full
                        val smallUrl = photo.urls.small
                        val username = photo.user.username
                        val description = photo.description
                        neededPhotoDataList.add(
                            NeededPhotoData(fullUrl, smallUrl, username, description)
                        )
                    }
                    processedData.postValue(neededPhotoDataList)
                }
            }
            cancel()
        }
    }

}