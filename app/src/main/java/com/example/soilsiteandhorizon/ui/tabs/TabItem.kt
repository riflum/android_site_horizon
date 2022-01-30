package com.example.soilsiteandhorizon.ui.tabs

import androidx.compose.runtime.Composable
import com.example.soilsiteandhorizon.R


typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Music : TabItem(R.drawable.ic_music_foreground, "Music", { MusicScreen() })
    object Movies : TabItem(R.drawable.ic_movies_foreground, "Movies", { MoviesScreen() })
    object Books : TabItem(R.drawable.ic_book_foreground, "Books", { BooksScreen() })
}
