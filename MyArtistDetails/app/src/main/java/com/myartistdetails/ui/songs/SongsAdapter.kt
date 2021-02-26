package com.myartistdetails.ui.songs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.myartistdetails.R
import com.myartistdetails.data.model.SongItem
import com.myartistdetails.databinding.RecyclerviewSongsBinding

class SongsAdapter(private val songs : List<SongItem>):
    RecyclerView.Adapter<SongsAdapter.SongsViewHolder>() {

    inner class SongsViewHolder(val recyclerviewSongsBinding : RecyclerviewSongsBinding)
        : RecyclerView.ViewHolder(recyclerviewSongsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SongsViewHolder(
            DataBindingUtil.inflate<RecyclerviewSongsBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_songs,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.recyclerviewSongsBinding.song = songs[position]

    }

    override fun getItemCount() = songs.size
}