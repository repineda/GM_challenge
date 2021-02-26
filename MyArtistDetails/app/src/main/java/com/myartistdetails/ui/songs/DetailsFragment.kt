package com.myartistdetails.ui.songs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.myartistdetails.R
import com.myartistdetails.data.network.SongsApi
import com.myartistdetails.data.repository.SongsRepository


import kotlinx.android.synthetic.main.details_fragment.*

class DetailsFragment : Fragment() {

    private lateinit var factory: DetailsViewModelFactory
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progress_loader.visibility = View.GONE
        btn_search.setOnClickListener {
            progress_loader.visibility = View.VISIBLE
            val api = SongsApi()
            val repository = SongsRepository(api)
            factory = DetailsViewModelFactory(repository)
            viewModel = ViewModelProviders.of(this, factory).get(DetailsViewModel::class.java)
            viewModel.getSongs(et_enterArtist.text.toString())
            viewModel.songs.observe(viewLifecycleOwner, Observer { songs ->
                recycler_view_songs.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = SongsAdapter(songs)
                    progress_loader.visibility = View.GONE
                }
            })
        }
    }



}
