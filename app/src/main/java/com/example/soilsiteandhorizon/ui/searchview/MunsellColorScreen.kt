package com.example.soilsiteandhorizon.ui.searchview

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.soilsiteandhorizon.ui.destinations.SettingBahasaScreenDestination

import com.example.soilsiteandhorizon.ui.presentation.SoilParameterViewModel
import com.example.soilsiteandhorizon.ui.tabs.TopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination/*(start = true)*/
@Composable
fun MunsellColorScreen(
    navigator: DestinationsNavigator,
    viewModel: SoilParameterViewModel = hiltViewModel(),
) {

    val munsellItems = viewModel.soilMunsellItems.collectAsState(initial = emptyList())
    val filterHue = munsellItems.value.filter {
        it.soilColorHue == "10YR"
    }

    val radioButtonValue = viewModel.radioButtonValue.observeAsState()

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Munsell Soil Color")
                },
                actions = {
                    IconButton(onClick = {
                        navigator.navigate(SettingBahasaScreenDestination)
                    }) {
                        Icon(Icons.Default.Settings,"")
                    }
                }
            )
        }
    ){
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
                    if(radioButtonValue.value == "Bahasa Indonesia"){
                        Text(text = "${it.soilColorCode} : ${it.textIndonesia}")
                    } else {
                        Text(text = "${it.soilColorCode} : ${it.textEnglish}")
                    }
                }
            }

        }
    }

}

@Destination
@Composable
fun SettingBahasaScreen(
    navigator: DestinationsNavigator
) {
    val mRememberObserver = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        GroupedRadioButton()
    }
}

@Composable
fun GroupedRadioButton(
    viewModel:SoilParameterViewModel = hiltViewModel()
) {
    val radioOptions = listOf("Bahasa Inggris", "Bahasa Indonesia")
    val (selectedOption, onOptionSelected) = rememberSaveable  { mutableStateOf(radioOptions[0])}
    val mRememberObserver = viewModel.radioButtonValue.observeAsState()

    Column (Modifier.selectableGroup()) {
        radioOptions.forEach { mItem ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (mItem == selectedOption),
                        onClick = { onOptionSelected(mItem) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (mItem == selectedOption),
                    onClick = null
                )
            }
            Text(
                text = mItem,
                style = MaterialTheme.typography.body1.merge(),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}