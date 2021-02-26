package com.myartistdetails.ui.songs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myartistdetails.data.repository.SongsRepository

@Suppress("UNCHECKED_CAST")
class DetailsViewModelFactory(private val repository: SongsRepository)
    : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}