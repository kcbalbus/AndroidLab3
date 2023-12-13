package com.example.androidlab2

import MoviesViewModel
import android.content.Context
import android.graphics.Color
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.util.Util
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player

@Composable
fun TrailersScreen(moviesViewModel: MoviesViewModel, moviesState: MoviesState, context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {

        VideoPlayer(
            moviesState.currentMovie.getTrailderIds(),
            context
        )
    }
}

@Composable
fun VideoPlayer(trailersIds: List<Int>, context: Context) {

    val exoPlayer = ExoPlayer.Builder(context).build()

    for (trailerId in trailersIds) {
        val uri = Uri.parse("android.resource://${context.packageName}/${trailerId}")
        val mediaItem = MediaItem.fromUri(uri)
        exoPlayer.addMediaItem(mediaItem)
    }

    exoPlayer.setRepeatMode(Player.REPEAT_MODE_ALL)

    val playerView = StyledPlayerView(context)
    playerView.player=exoPlayer

    DisposableEffect(
        AndroidView(
            factory = {playerView},
            modifier = Modifier
                .fillMaxSize()
        )
    ){
        exoPlayer.prepare()
        exoPlayer.play()

        onDispose {
            exoPlayer.release()
        }
    }

}

