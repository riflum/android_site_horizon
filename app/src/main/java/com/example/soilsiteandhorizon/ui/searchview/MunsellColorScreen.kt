package com.example.soilsiteandhorizon.ui.searchview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.soilsiteandhorizon.ui.presentation.SoilParameterViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MunsellColorScreen(
//    navigator: DestinationsNavigator,
    viewModel: SoilParameterViewModel = hiltViewModel(),
) {

    val munsellItems = viewModel.soilMunsellItems.collectAsState(initial = emptyList())
    val filterHue = munsellItems.value.filter {
        it.soilColorHue == "10YR"
    }
    Column() {
        LazyColumn {
            /*items(munsellItems.value){
                Text(text = "List Color: ${it.id}, code: ${it.soilColorCode}")
            }*/
            item {
                Text(
                    text = "10YR",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            }
            items(filterHue){
                Text(text = "${it.soilColorCode} : ${it.textIndonesia}")
            }
        }

    }
}