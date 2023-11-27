package com.example.androidlab2

data class MoviesState(
    val movies: List<Movie> = emptyList(),
    val currentMovie: Movie = Movie("a", "a", "a", emptyList(), emptyList()),
    val scenesView: String = "scenes"
)
