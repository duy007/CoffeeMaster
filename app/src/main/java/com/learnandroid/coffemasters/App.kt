package com.learnandroid.coffemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.learnandroid.coffemasters.pages.InfoPage
import com.learnandroid.coffemasters.pages.MenuPage
import com.learnandroid.coffemasters.pages.OffersPage
import com.learnandroid.coffemasters.pages.OrderPage
import com.learnandroid.coffemasters.ui.theme.CoffeMastersTheme

//@Preview
//@Composable
//fun App_Preview() {
//    CoffeMastersTheme {
//        (App())
//    }
//}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App(dataManager: DataManager) {
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold (
        topBar = {
            TopAppBar() {
                AppTitle()
            }
        },
        content = {
            when(selectedRoute.value) {
                Routes.OffersPage.route -> OffersPage()
                Routes.MenuPage.route -> MenuPage(dataManager)
                Routes.InfoPage.route -> InfoPage()
                Routes.OrderPage.route -> OrderPage(dataManager)
            }
        },
        bottomBar = {
            NavBar(selectedRoute = selectedRoute.value,onChange = {newRoute ->
                selectedRoute.value = newRoute
            })
        }
    )
}


@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Image(painter = painterResource(R.drawable.logo)
            ,contentDescription = "Coffe Masters Logo")
    }
}