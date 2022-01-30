package com.example.soilsiteandhorizon.ui.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soilsiteandhorizon.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import org.w3c.dom.Text


@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    // OR ScrollableTabRow()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = colorResource(id = R.color.design_default_color_primary_dark),
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            // OR Tab()
            LeadingIconTab(
                icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = "") },
                text = { Text(text = tab.title, fontSize = 10.sp) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@Composable
fun TabSimple() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Hello", "There", "World")

    Column {
        TabRow(selectedTabIndex = tabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }
                )
            }
        }
        when (tabIndex) {
            0 -> Text("Hello Content")
            1 -> Text("There content")
            2 -> Text("World content")
        }
    }
}


@Composable
fun TabWithSwiping() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitle =
        listOf("Horison 1", "Horison 2", "Horison 3", "Horison 4", "Horison 5", "Horison 6")

    var noFormHor1 by remember { mutableStateOf("") }
    Column {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            edgePadding = 4.dp
        ) {
            tabTitle.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                ) {
                    Text(text = title, modifier = Modifier.padding(16.dp))
                }
            }
        }
        when (tabIndex) {
            0 -> Horison(tabTitle[0], modifier = Modifier.padding(8.dp))
            1 -> OutlinedTextField(
                value = noFormHor1,
                onValueChange = { noFormHor1 = it },
                label = { Text("No Form") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            2 -> Text("Hello ${tabTitle[2]}")
            3 -> Text("Hello ${tabTitle[3]}")
            4 -> Text("Hello ${tabTitle[4]}")
        }
    }
}

@Composable
fun Horison(nomorHorison: String, modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(value = "",
            onValueChange = {},
            label = { Text("Label1 ${nomorHorison}") },
            modifier = Modifier)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = "",
            onValueChange = {},
            label = { Text("Label2 ${nomorHorison}") },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth())
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = "",
            onValueChange = {},
            label = { Text("Label3 ${nomorHorison}") },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth())
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = "",
            onValueChange = {},
            label = { Text("Label4 ${nomorHorison}") },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth())
    }
}


@Preview(showBackground = true)
@Composable
fun TabWithSwipingPreview() {
    TabWithSwiping()
}