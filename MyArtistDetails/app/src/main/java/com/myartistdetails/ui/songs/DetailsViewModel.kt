package com.myartistdetails.ui.songs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myartistdetails.util.Coroutines
import com.myartistdetails.data.model.SongItem
import com.myartistdetails.data.repository.SongsRepository
import kotlinx.coroutines.Job

class DetailsViewModel(private val repository: SongsRepository)
    : ViewModel() {

    private lateinit var job : Job
    private val _songs = MutableLiveData<List<SongItem>>()
    val songs : LiveData<List<SongItem>>
    get() = _songs


     fun getSongs(artist : String)
    {
        job = Coroutines.ioToMain(
            { repository.getSongs(artist) },
            { _songs.value = it?.results }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}