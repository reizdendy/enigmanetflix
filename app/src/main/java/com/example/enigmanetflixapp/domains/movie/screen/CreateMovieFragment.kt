package com.example.enigmanetflixapp.domains.movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigmanetflixapp.R
import com.example.enigmanetflixapp.domains.movie.Movie
import com.example.enigmanetflixapp.domains.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_create_movie.*

/**
 * A simple [Fragment] subclass.
 * Use the [CreateMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateMovieFragment : Fragment() {
    private val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCreateMovie.setOnClickListener{
            val newMovie = Movie(title = inputMovieTitle.text.toString(), duration = inputMovieDuration.text.toString(),
            imgUrl = inputMovieImage.text.toString(), synopsis = inputMovieSynopsis.text.toString())
            movieViewModel.createMovie(newMovie)
            Navigation.findNavController(view).navigate(R.id.action_goodAddFragment_pop)
        }
    }
}