package com.example.androidlab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlab2.ui.theme.MovieMenuTheme

class MovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie =Movie("a", "bekarty_wojny_cover", "W okupowanej przez nazistów Francji oddział złożony z Amerykanów żydowskiego pochodzenia planuje zamach na Hitlera.", listOf("bekarty_wojny_scene1", "bekarty_wojny_scene2"), listOf("Brad Pitt", "Christopher Waltz"))
        setContent {
            MovieMenuTheme {
                Column {
                    MovieDesc(movie)
                    ScenesActorsButtons()
                    ScenesGrid(movie.getScenesIds())
                }

            }
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
fun ScenesActorsButtons () {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                //.border(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "SCENY",
                style = MaterialTheme.typography.labelLarge,

            )
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = "AKTORZY",
                style = MaterialTheme.typography.labelLarge,

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
            Text(text = actor)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
            )
        }

    }
}

@Composable
@Preview
fun PreviewTest() {
    val movie =Movie("a", "bekarty_wojny_cover", "W okupowanej przez nazistów Francji oddział złożony z Amerykanów żydowskiego pochodzenia planuje zamach na Hitlera.", listOf("bekarty_wojny_scene1", "bekarty_wojny_scene2"), listOf("Brad Pitt", "Christopher Waltz"))
    MovieMenuTheme {
        Column {
            MovieDesc(movie)
            ScenesActorsButtons()
            ScenesGrid(movie.getScenesIds())
        }

    }
}