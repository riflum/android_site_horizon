package com.example.soilsiteandhorizon.ui.soilScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.soilsiteandhorizon.data.SoilParameterEntity
import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import com.example.soilsiteandhorizon.ui.destinations.DetailScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ListOfSoilParameter(
    soilDatas: State<List<SoilParameterEntity>>,
//    navigator: DestinationsNavigator
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
                            /*navigator.navigate(
                                DetailScreenDestination(
                                    "${it.soilParameterId}",
                                    "${it.title}"
                                )
                            )*/
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