package com.example.soilsiteandhorizon.ui.soilScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.soilsiteandhorizon.data.SoilParameterEntity
import com.example.soilsiteandhorizon.ui.destinations.DetailScreenDestination
import com.example.soilsiteandhorizon.ui.destinations.SegitigaTeksturDestination
import com.example.soilsiteandhorizon.ui.presentation.SoilParameterViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Destination
@Composable
fun DefaultScaffold(
    viewModel: SoilParameterViewModel = hiltViewModel(),
    navigator:DestinationsNavigator,
) {
    val soilDatas = viewModel.soilDatas.collectAsState(initial = emptyList())

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    Scaffold(
        /*drawerContent = {
            Column() {
                Text("Drawer title", Modifier.padding(16.dp))
                Divider()
                Text(
                    "Segitiga Tekstur",
                    Modifier
                        .padding(16.dp)
                        .clickable {
                            scope.launch {
                                drawerState.close()
                            }
                            Log.e("DRAWER", "${drawerState.currentValue}")
    //                        navigator.navigate(SegitigaTeksturDestination())
                        },

                    )
                Divider()
                Text("ITEM 2",Modifier.padding(16.dp))
                Divider()
                Button(onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }) {

                }
            }

        },*/
        topBar = {
            TopAppBar() {
                IconButton(
                    modifier = Modifier.fillMaxWidth(0.1F),
                    onClick = {
                    scope.launch {
                        if (drawerState.isClosed)
                            drawerState.open()
                        else
                            drawerState.close()
                    }
                }) {
                    Icon(Icons.Filled.Menu, "")

                }
                Text(
                    text = "Pedoman Pengisian Form",
                    modifier = Modifier.padding(start = 16.dp).fillMaxWidth(0.8F),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Default.Search,"")
                }
            }
        },
    ) {
        ModalDrawer(
            drawerContent = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = {
                        scope.launch {
                            drawerState.close()
                        }
//                        navigator.navigate(SegitigaTeksturDestination())
                    }) {
                        Text(text = "Segitiga Tekstur")

                    }
                }
            },
            drawerState = drawerState
        ) {
            ListOfSoilParameter(soilDatas = soilDatas)
        }
    }
}