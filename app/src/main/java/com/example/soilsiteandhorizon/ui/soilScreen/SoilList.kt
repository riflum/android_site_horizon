package com.example.soilsiteandhorizon.ui.list

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.soilsiteandhorizon.ui.destinations.DetailScreenDestination
import com.example.soilsiteandhorizon.ui.destinations.HomeScreenDestination
import com.example.soilsiteandhorizon.ui.destinations.SegitigaTeksturDestination
import com.example.soilsiteandhorizon.ui.presentation.SoilParameterViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

//@Destination(start = true)
@Destination
@Composable
fun SoilList(
    navigator: DestinationsNavigator,
    viewModel: SoilParameterViewModel = hiltViewModel()
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
            TopAppBar{
                IconButton(onClick = {
                    scope.launch {
                        if (drawerState.isClosed)
                            drawerState.open()
                        else
                            drawerState.close()
                    }
                }) {
                    Icon(Icons.Filled.Menu, "" )

                }
                Text(
                    text = "Pedoman Pengisian Form",
                    modifier = Modifier.padding(start =16.dp),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
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
                        navigator.navigate(SegitigaTeksturDestination())
                    }) {
                        Text(text = "Segitiga Tekstur")

                    }
                }
            },
            drawerState = drawerState
        ) {
            LazyColumn(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(soilDatas.value) {
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        elevation = 3.dp
                    ) {
                        Text(
                            text = "${it.combId}. ${it.title}:",
                            modifier = Modifier
                                .clickable {
                                    // TODO: using when -> to blok/limit some of the list when navigate to detail screen
                                    // check if soilId is 1 dont navigate to Detail Screen
                                    /*  when (it.soilId) {
                                    1, 2, 3, 4, 5, 7, 8, 10, 13, 14, 17, 22, 26, 31 -> Log.e("LOG",
                                        "Do NOTHING")
                                    else -> navigator.navigate(
                                        SoilDetailDestination(
                                            "${it.soilParameterId}",
                                            "${it.title}"
                                        )
                                    )
                                }*/
                                    navigator.navigate(
                                        DetailScreenDestination(
                                            "${it.soilParameterId}",
                                            "${it.title}"
                                        )
                                    ){

                                    }
                                    Log.e("LIST",
                                        "soilId: ${it.combId}, id: ${it.id}, no: ${it.combId}")
                                }
                                .padding(16.dp)
                                .fillMaxWidth(),

                            )
                    }
                    Spacer(modifier = Modifier.size(4.dp))
                }

            }
        }
    }


}
