package com.example.enigmanetflixapp.domains.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigmanetflixapp.config.RetrofitBuilder

class MovieViewModel(application: Application) : AndroidViewModel(application){
    private val movieRepository:MovieRepository

    init {
        val movieAPI = RetrofitBuilder.createRetrofit().create(MovieAPI::class.java)
        movieRepository = MovieRepository(movieAPI)
    }

    val movie: LiveData<Movie> = movieRepository.movie
    val allMovie : LiveData<List<Movie>> = movieRepository.allMovie

    fun getMovieByID(id: String) {
        movieRepository.getMovieByID(id)
    }

    fun createMovie(movie: Movie) {
        movieRepository.createMovie(movie)
    }

    fun getAllMovie() = movieRepository.getAllMovie()
}