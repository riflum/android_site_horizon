package com.example.soilsiteandhorizon.ui.soilScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import com.example.soilsiteandhorizon.ui.presentation.SoilParameterViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailScreen(
    navigator: DestinationsNavigator,
    soilParameterId: String,
    title: String,
    viewModel: SoilParameterViewModel = hiltViewModel(),
) {
    // Get all the soil Code data
    val soilCodes = viewModel.soilCodes.collectAsState(initial = emptyList())

    // FOR MutableLiveData<List<T>>
    val soilItems: List<SoilCodeEntity> by viewModel.soilItems.observeAsState(listOf())

//    val soilItems:List<SoilCodeEntity> = viewModel.soilItems
    // Sent The Event to ViewModel to query Soil Code by ID=soilData
    viewModel.getSoilId(soilParameterId)

    Log.e("TEEST", "${soilItems.size}")
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "${title}",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(10.dp)
                )
                Divider(color = Color.Blue,
                    thickness = 1.dp)
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(4.dp))
            }

            items(soilItems) { soilItem ->

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 8.dp
                ) {
                    Row() {
                        Text(
                            modifier = Modifier
                                .clickable {
                                    Log.e(
                                        "TAG",
                                        "soilId: ${soilItem.code}, English: ${soilItem.textEnglish}"
                                    )
                                }
                                .padding(start = 20.dp)
                                .fillMaxWidth()
                                .weight(0.25f)
                                .align(alignment = Alignment.CenterVertically),
                            text = soilItem.code,
                            style = MaterialTheme.typography.subtitle2

                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            modifier = Modifier
                                .clickable {
                                    Log.e(
                                        "TAG",
                                        "soilId: ${soilItem.code}, English: ${soilItem.textEnglish}"
                                    )
                                }
                                .padding(8.dp)
                                .fillMaxWidth()
                                .weight(0.75f),
                            text = soilItem.textIndonesia,
                            style = MaterialTheme.typography.subtitle2

                        )

                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
            }
        }
    }

}