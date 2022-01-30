package com.example.soilsiteandhorizon.ui.entri_site_horizon

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import com.example.soilsiteandhorizon.R
import com.example.soilsiteandhorizon.ui.destinations.MusicScreenDestination

@Composable
fun MainEntryScreen() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { /*TODO add here*/},
        drawerBackgroundColor = colorResource(id = R.color.primaryColor),
        drawerContent = {
            /*Todo: Add code later*/
        }
    ) {
    }
}