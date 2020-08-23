package com.example.enigmanetflixapp.domains.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmanetflixapp.R
import com.squareup.picasso.Picasso

class MovieRecycleAdapter (private val movieList: List<Movie>,
private val getActivity: FragmentActivity?
) : RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_recycle_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Picasso.with(getActivity).load(movieList[position].imgUrl).into(holder.movieImage)
        Picasso.get().load(movieImage).into(holder.movieImage)
        val bundle = bundleOf(
            Pair("name", movieList[position].title),
            Pair("image", movieList[position].imgUrl),
            Pair("idMovie", movieList[position].id),
            Pair("desc", movieList[position].synopsis)
        )
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_movieListFragment_to_movieFragment, bundle)
        }
    }
}


class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val movieImage: ImageView = v.findViewById(R.id.imageMovieRecycleView)
}