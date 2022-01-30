package com.example.soilsiteandhorizon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.soilsiteandhorizon.ui.NavGraphs
import com.example.soilsiteandhorizon.ui.entri_site_horizon.MainEntryScreen
import com.example.soilsiteandhorizon.ui.etc.LazyColumnItemTest
import com.example.soilsiteandhorizon.ui.soilScreen.DefaultScaffold
import com.example.soilsiteandhorizon.ui.tabs.MainScreen
import com.example.soilsiteandhorizon.ui.tabs.TabWithSwiping
import com.example.soilsiteandhorizon.ui.theme.SoilSiteAndHorizonTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import com.google.accompanist.pager.ExperimentalPagerApi as ExperimentalPagerApi1


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi1::class,ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoilSiteAndHorizonTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    ModalDrawerExample()
//                    DestinationsNavHost(navGraph = NavGraphs.root)
//                    TabWithSwiping()
//                    DefaultScaffold()
                    MainEntryScreen()

                }
            }
        }
    }
}




