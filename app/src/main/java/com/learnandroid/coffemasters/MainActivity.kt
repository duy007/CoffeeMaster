package com.learnandroid.coffemasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.learnandroid.coffemasters.ui.theme.CoffeMastersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // passing a class by argument DataManager::class
        // we are asking the framework to create the data manager class
        // ViewModelProvider will the now that create the async functionalies
        // and deal with multi-threading
        var dataManager = ViewModelProvider(this)
            .get(DataManager::class.java)
        setContent {
            CoffeMastersTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    // changes what we want to render
                    App(dataManager)
//                    FirstComposable()
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun FirstComposable() {
    var name = remember {
        mutableStateOf("")
    }
    Column {
        Text(text = "Hello ${name.value}",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Yellow)
                .padding(16.dp)

        )
        TextField(value = name.value, onValueChange = {
            name.value = it
        })
    }
}


