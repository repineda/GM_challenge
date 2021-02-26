package com.myartistdetails.data.network

import com.myartistdetails.data.model.ArtistResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SongsApi {
    @GET("search")
    suspend fun getArtist(@Query("term") artist : String) : Response<ArtistResponse>

    companion object{
        operator fun invoke() : SongsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://itunes.apple.com/")
                .build()
                .create(SongsApi::class.java)
        }
    }
}