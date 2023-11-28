package com.example.androidlab2

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


data class Movie(val title: String, val cover: String, val description: String, val scenes: List<String>, val actors: List<String>, val trailers: List<String>) {

    @Composable
    fun getCoverId (): Int {
        val resources = LocalContext.current.resources
        return resources.getIdentifier(cover, "drawable", LocalContext.current.packageName)
    }

    @Composable
    fun getScenesIds (): List<Int> {
        var scenesIds: MutableList<Int> = mutableListOf()
        val resources = LocalContext.current.resources

        scenes.forEach { scene ->
            scenesIds.add(resources.getIdentifier(scene, "drawable", LocalContext.current.packageName))
        }

        return scenesIds.toList()
    }

    @Composable
    fun getTrailderIds (): List<Int> {
        var trailerIds: MutableList<Int> = mutableListOf()
        val resources = LocalContext.current.resources

        trailers.forEach { trailer ->
            trailerIds.add(resources.getIdentifier(trailer, "drawable", LocalContext.current.packageName))
        }

        return trailerIds.toList()
    }
}