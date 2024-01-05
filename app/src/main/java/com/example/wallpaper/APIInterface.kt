package com.example.wallpaper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface APIInterface {

    @GET("api/")
    fun searchImageAPI(
        @Query("key") key:String,@Query("q") q:String,@Query("image_type") image_type:String

    ):Call<ImageModel>
}