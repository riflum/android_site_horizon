package com.example.soilsiteandhorizon.ui.searchview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.soilsiteandhorizon.R
import com.example.soilsiteandhorizon.data.SoilParameterEntity
import com.example.soilsiteandhorizon.ui.destinations.DetailScreenDestination
import com.example.soilsiteandhorizon.ui.destinations.SearchDetailScreenDestination
import com.example.soilsiteandhorizon.ui.presentation.SoilParameterViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
//@Destination
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
    viewModel: SoilParameterViewModel = hiltViewModel(),
) {
    val state: List<SoilParameterEntity> by viewModel.soilParameterItems.observeAsState(listOf())
//    viewModel.onSearch("")
    val textValue = viewModel.searchQuery

    val focusManager = LocalFocusManager.current

    Surface (
        color = Color.White,
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = textValue.value,
                onValueChange = viewModel::onSearch,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                label = { Text("Search", color = Color.Black) },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {focusManager.clearFocus()}),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                },
                trailingIcon = {
                    if (textValue.value != "") {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "",
                            modifier = Modifier
                                .clickable {
                                    viewModel.setTextFieldValue("")
                                    viewModel.onSearch("")
                                }
                                .padding(15.dp)
                                .size(24.dp)
                        )

                    }
                },
                singleLine = true,
                shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
                 colors = TextFieldDefaults.textFieldColors(
                     textColor = Color.Black,
                     cursorColor = Color.Black,
                     leadingIconColor = Color.Black,
                     trailingIconColor = Color.Black,
                     backgroundColor = Color.LightGray,
                     focusedIndicatorColor = Color.Transparent,
                     unfocusedIndicatorColor = Color.Transparent,
                     disabledIndicatorColor = Color.Transparent
                 )
            )

            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Start),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                state.forEach {
                    item {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            elevation = 8.dp
                        ) {
                            Row() {
                                Text(
                                    text = "${it.combId}",
                                    modifier = Modifier
                                        .clickable {
                                            navigator.navigate(
                                                SearchDetailScreenDestination(
                                                    "${it.soilParameterId}",
                                                    "${it.title}"
                                                )
                                            )
                                        }
                                        .background(Color.White)
                                        .padding(12.dp)
                                        .fillMaxWidth()
                                        .weight(0.2f)
                                        .align(Alignment.CenterVertically),
                                    color = Color.Black

                                )
                                Text(
                                    text = "${it.title}",
                                    modifier = Modifier
                                        .clickable {
                                            navigator.navigate(
                                                SearchDetailScreenDestination(
                                                    "${it.soilParameterId}",
                                                    "${it.title}"
                                                )
                                            )
                                        }
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                        .weight(0.8f)
                                        .align(Alignment.CenterVertically),
                                    color = Color.Black

                                )

                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                    }

                }
            }

        }
    }
}

