package com.myartistdetails.data.repository

import com.myartistdetails.data.network.SongsApi

class SongsRepository(private val api: SongsApi) : ApiRequest(){

    suspend fun getSongs(artist : String) = apiRequest { api.getArtist(artist) }
}