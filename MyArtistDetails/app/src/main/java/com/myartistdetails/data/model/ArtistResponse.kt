package com.myartistdetails.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ArtistResponse(val results: List<SongItem>){
}

@Parcelize
data class SongItem(
    val artistName : String,
    val trackName : String,
    val releaseDate : String,
    val primaryGenreName : String,
    val trackPrice : Double,
    val artworkUrl100 : String
): Parcelable