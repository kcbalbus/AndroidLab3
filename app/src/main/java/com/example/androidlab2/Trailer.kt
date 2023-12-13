package com.example.androidlab2

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


data class Trailer(val title: String, val file:String) {

    @Composable
    fun getTrailerId (): Int {
        val resources = LocalContext.current.resources

        return resources.getIdentifier(file, "raw", LocalContext.current.packageName)
    }
}