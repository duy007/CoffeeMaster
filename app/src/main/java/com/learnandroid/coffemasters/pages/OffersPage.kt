package com.learnandroid.coffemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learnandroid.coffemasters.DataManager
import com.learnandroid.coffemasters.R
import com.learnandroid.coffemasters.ui.theme.Alternative2

// set private to only development use only
//@Preview (showBackground = true, widthDp = 400)
//@Composable
//private fun Offer_Preview() {
//    Offer("My title 1", "My Description")
//}

@Composable
fun OffersPage() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())

    ) {
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")

    }
}

@Composable
fun Offer(title: String, description: String) {
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Image(painter = painterResource(R.drawable.background_pattern),
            contentDescription = "background pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp))
            Text(text = description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp))
        }
    }
}