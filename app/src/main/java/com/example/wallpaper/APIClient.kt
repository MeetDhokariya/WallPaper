package com.example.wallpaper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object{
        var retrofit : Retrofit? = null
        var BaseUrl = "https://pixabay.com/"

        fun getAPIClient():Retrofit?{

            if (retrofit == null)
            {
                retrofit = Retrofit.Builder().baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit

        }
    }
}