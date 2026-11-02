package com.kabi.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kabi.bookpedia.app.App
import com.kabi.bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}