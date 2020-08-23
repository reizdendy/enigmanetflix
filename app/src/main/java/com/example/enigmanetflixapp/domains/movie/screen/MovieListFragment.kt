package com.example.enigmanetflixapp.domains.movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmanetflixapp.R
import com.example.enigmanetflixapp.domains.movie.MovieRecycleAdapter
import com.example.enigmanetflixapp.domains.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*


/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {

    private val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListRecycleView.layoutManager = LinearLayoutManager(activity)

        movieViewModel.allMovie.observe(viewLifecycleOwner, Observer {
            movieListRecycleView.adapter = MovieRecycleAdapter(it, activity)
        })
        movieViewModel.getAllMovie()
    }

}