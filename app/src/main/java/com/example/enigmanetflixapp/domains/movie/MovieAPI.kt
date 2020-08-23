package com.example.enigmanetflixapp.domains.movie

import com.example.enigmanetflixapp.domains.response_data.ResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieAPI{

    @GET("film")
    fun getAllMovie (): Call<ResponseData>


    @GET("film/{id}")
    fun getMovieByID (@Path("id")id:String): Call<ResponseData>

    @POST("film")
    fun createMovie(@Body movie: Movie): Call<ResponseData>

}