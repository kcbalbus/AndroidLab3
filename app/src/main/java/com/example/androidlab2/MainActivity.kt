package com.example.androidlab2

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlab2.ui.theme.MovieMenuTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //save_movies(this)
        val movies = load_movies(this)

        setContent {
            MovieMenuTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MovieMenu(movies)
                }
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
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

@Composable
fun MovieMenu(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
            )
        }

    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MoviesPreview() {
    MovieMenuTheme {
        Surface {
            MovieCard(movie = Movie("b", "bekarty_wojny_cover", "b", listOf("b"), listOf("b")))
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewConversation() {
    MovieMenuTheme {
        MovieMenu(listOf(Movie("a", "bekarty_wojny_cover", "b", listOf("b"), listOf("b")), Movie("b", "bekarty_wojny_cover", "b", listOf("b"), listOf("b"))))
    }
}

fun save_movies(context: Context){
    val movies = listOf(
        Movie("Wyspa Tajemnic", "wyspa_tajemnic_cover", "Szeryf federalny Daniels stara się dowiedzieć, jakim sposobem z zamkniętej celi w pilnie strzeżonym szpitalu dla chorych psychicznie przestępców zniknęła pacjentka.", listOf("wyspa_tajemnic_scene1", "wyspa_tajemnic_scene2","wyspa_tajemnic_scene3","wyspa_tajemnic_scene4","wyspa_tajemnic_scene5","wyspa_tajemnic_scene6"), listOf("Leonardo DiCaprio", "Mark Ruffalo", "Mark Ruffalo", "Max von Sydow", "Michelle Williams")),
        Movie("Bękarty Wojny", "bekarty_wojny_cover", "W okupowanej przez nazistów Francji oddział złożony z Amerykanów żydowskiego pochodzenia planuje zamach na Hitlera.", listOf("bekarty_wojny_scene1", "bekarty_wojny_scene2","bekarty_wojny_scene3","bekarty_wojny_scene4","bekarty_wojny_scene5","bekarty_wojny_scene6","bekarty_wojny_scene7"), listOf("Brad Pitt", "Mélanie Laurent", "Christoph Waltz", "Eli Roth", "Daniel Brühl")),
        Movie("Baby Driver", "baby_driver_cover", "Chcący zerwać z kryminalną przeszłością młody chłopak, zmuszany do pracy dla bossa mafii, zostaje wrobiony w napad skazany na niepowodzenie.", listOf("baby_driver_scene1", "baby_driver_scene2","baby_driver_scene3","baby_driver_scene4","baby_driver_scene5","baby_driver_scene6", "baby_driver_scene7","baby_driver_scene8","baby_driver_scene9"), listOf("Ansel Elgort", "Kevin Spacey", "Lily James", "Jon Hamm", "Jamie Foxx", "Eiza González")),
    )

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPreferences.edit()
    val gson = Gson()
    val json = gson.toJson(movies)

    editor.putString("movies", json)
    editor.apply()

}

fun load_movies(context: Context): List<Movie>{
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    val gson = Gson()
    val json = sharedPreferences.getString("movies", null)


    if (json != null) {
        val loadedData: List<Movie> = gson.fromJson(json, object : TypeToken<List<Movie>>() {}.type)
        return loadedData
    }

    return  listOf()
}