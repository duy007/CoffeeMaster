package com.learnandroid.coffemasters

import android.icu.text.IDNA.Info
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learnandroid.coffemasters.ui.theme.Alternative1
import com.learnandroid.coffemasters.ui.theme.OnPrimary
import com.learnandroid.coffemasters.ui.theme.Primary

data class NavPage(var name: String, var icon: ImageVector,
                   var route: String)

object Routes {
    var MenuPage = NavPage("Menu", Icons.Outlined.Menu, "menu")
    var OffersPage =NavPage("Offers", Icons.Outlined.Star, "offer")
    var OrderPage = NavPage("My Order", Icons.Outlined.ShoppingCart, "order")
    var InfoPage = NavPage("Info", Icons.Outlined.Info, "info")

    var pages = listOf(MenuPage, OffersPage, OrderPage, InfoPage)
}


@Preview
@Composable
fun NavBarItem_Preview() {
    NavBarItem(Routes.MenuPage, modifier = Modifier.padding(8.dp))
}


@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route,
                onChange: (String) -> Unit
           ) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        for (page in Routes.pages) {
            NavBarItem(page,
            selected = selectedRoute == page.route,
            modifier = Modifier.clickable {
                onChange(page.route)
            })
        }
    }
}
@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected)  OnPrimary else  Alternative1
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) OnPrimary else  Alternative1
        )
    }
}