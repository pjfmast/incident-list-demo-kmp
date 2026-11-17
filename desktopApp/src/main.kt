package com.example.incident_list_demo_kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "incident-list-demo-kmp") {
        App()
    }
}
