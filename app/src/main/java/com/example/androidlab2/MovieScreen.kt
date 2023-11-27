package com.example.androidlab2

import MoviesViewModel
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidlab2.ui.theme.MovieMenuTheme
import com.example.androidlab2.ui.theme.White


@Composable
fun MovieScreen (moviesViewModel: MoviesViewModel, moviesState: MoviesState) {


    Column {
        MovieDesc(moviesState.currentMovie)

        ScenesActorsButtons({moviesViewModel.updateScenesOrActorsView(it)} )

        if(moviesState.scenesView.equals("scenes")) {
            ScenesGrid(moviesState.currentMovie.getScenesIds())
        } else {
            ActorsList(moviesState.currentMovie.actors)
        }

    }
}

@Composable
fun MovieDesc (movie: Movie) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
    ) {
        Image(
            painter = painterResource(id = movie.getCoverId()),
            contentDescription = "Movie's cover art",
            modifier = Modifier
                .size(150.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = movie.description,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ScenesActorsButtons (onAction: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextButton(
            onClick =  {onAction("scenes")} ,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(R.string.sceny),
                style = MaterialTheme.typography.labelLarge,
                color = White
                )
        }

        TextButton(
            onClick =  {onAction("actors")} ,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(R.string.aktorzy),
                style = MaterialTheme.typography.labelLarge,
                color= White
            )
        }

    }
}

@Composable
fun ScenesGrid(scenes: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(scenes) { scene ->
                Image(
                    painter = painterResource(id = scene),
                    contentDescription = "Scene",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    )
}


@Composable
fun ActorsList(actors: List<String>) {
    LazyColumn {
        items(actors) { actor ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = actor,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
            )
        }

    }
}
/*
@Composable
@Preview
fun PreviewTest() {
    MovieMenuTheme {
        MovieScreen()

    }
}*/