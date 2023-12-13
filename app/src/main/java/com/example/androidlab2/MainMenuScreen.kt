package com.example.androidlab2

import MoviesViewModel
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidlab2.ui.theme.MovieTheme



@Composable
fun MovieMenu(moviesViewModel: MoviesViewModel, moviesState: MoviesState, onMovieChosenNavigate:()-> Unit) {

    LazyColumn {
        items(moviesState.movies) { movie ->
            MovieCard(
                movie,
                {moviesViewModel.onMovieChosen(it)},
                onMovieChosenNavigate
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
            )
        }

    }
}


@Composable
fun MovieCard(movie: Movie, chooseMovie: (Movie) -> Unit, navigateChosenMovie: ()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .clickable(onClick =
            {
                chooseMovie(movie)
                navigateChosenMovie()
            })
    ) {
        Image(
            painter = painterResource(id = movie.getCoverId()),
            contentDescription = "Movie's cover art",
            modifier = Modifier
                .size(120.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
