package com.example.soilsiteandhorizon.ui.entri_site_horizon

import com.example.soilsiteandhorizon.R
import com.example.soilsiteandhorizon.ui.destinations.*

sealed class NavDrawerItem(var route: DirectionDestination, var icon: Int, var title: String) {
    object Home : NavDrawerItem(HomeScreenDestination(), R.drawable.ic_home, "Home")
    object Music : NavDrawerItem( MusicScreenDestination(), R.drawable.ic_music, "Music")
    object Movies : NavDrawerItem(MoviesScreenDestination(), R.drawable.ic_movie, "Movies")
    object Books : NavDrawerItem(BooksScreenDestination(), R.drawable.ic_book, "Books")
    object Settings : NavDrawerItem(SettingsScreenDestination(), R.drawable.ic_settings, "Settings")
}
