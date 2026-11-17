package com.example.incident_list_demo_kmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.incident_list_demo_kmp.ui.theme.IncidentListDemoTheme
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Composable
@Preview
@DevelopmentEntryPoint
fun App() {
    IncidentListDemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            IncidentsListScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
