package com.kabi.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.kabi.bookpedia.app.App
import com.kabi.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }