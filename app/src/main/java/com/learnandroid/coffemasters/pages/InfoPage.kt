package com.learnandroid.coffemasters.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyWebView() {
    val url = "https://firtman.github.io/coffeemasters/webapp"

    AndroidView(factory = {
        WebView(it).apply{
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            webViewClient = WebViewClient() // customeize web view (ex: disable JS, etc.)
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    }
    )
}

@Preview
@Composable
fun InfoPage() {
    MyWebView()
}