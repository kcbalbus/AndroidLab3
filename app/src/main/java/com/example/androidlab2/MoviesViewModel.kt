import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.androidlab2.Movie
import com.example.androidlab2.MoviesState
import com.example.androidlab2.R
import com.example.androidlab2.Trailer
import com.example.androidlab2.data.allMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MoviesViewModel : ViewModel() {
    private val _moviesState = MutableStateFlow(MoviesState())
    val moviesState: StateFlow<MoviesState> = _moviesState.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        _moviesState.value = MoviesState(movies = allMovies)
    }

    fun onMovieChosen(movie: Movie){
        _moviesState.update { currentState ->
            currentState.copy(
                currentMovie = movie
            )
        }

    }

    fun updateCurrentTrailer(trailer: Trailer){
        _moviesState.update { currentState ->
            currentState.copy(
                currentTrailer = trailer
            )
        }

    }

    fun updateScenesOrActorsView(button: String) {

        if(!button.equals(_moviesState.value.scenesView))
        {
            _moviesState.update { currentState ->
                currentState.copy(
                    scenesView = button
                )
            }
        }
    }

    fun getCurrentMovie(): String {
        return moviesState.value.currentMovie.title
    }
}
