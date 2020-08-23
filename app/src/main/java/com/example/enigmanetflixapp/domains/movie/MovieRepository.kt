package com.example.enigmanetflixapp.domains.movie

import androidx.lifecycle.MutableLiveData
import com.example.enigmanetflixapp.domains.response_data.ResponseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val movieAPI: MovieAPI) {
    val movie: MutableLiveData<Movie> = MutableLiveData<Movie>()
    var allMovie: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()

    fun getAllMovie(){
        movieAPI.getAllMovie().enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "200") {
                    val res = responseData.result
                    val gson = Gson()
                    val stringResponse = gson.toJson(res)
                    val movieObject:List<Movie> = gson.fromJson(stringResponse,Array<Movie>::class.java).toList()
                    allMovie.value = movieObject
                } else {
                    movie.value = Movie("", "Data not found", "")
                }
            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun getMovieByID(id: String) {
        movieAPI.getMovieByID(id).enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "200") {
                    val res = responseData.result
                    val gson = Gson()
                    movie.value = gson.fromJson(gson.toJson(res), Movie::class.java)
                } else {
                    movie.value = Movie("", "Data not found", "")
                }
            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun createMovie(movie: Movie) {
        movieAPI.createMovie(movie).enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "200") {
                    println(response.isSuccessful)
                }
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}