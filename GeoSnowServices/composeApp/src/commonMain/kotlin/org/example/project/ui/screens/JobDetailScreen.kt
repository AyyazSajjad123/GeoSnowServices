package org.example.project.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class JobDetailScreen(private val address: String) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var isAtLocation by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Job Details") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    navigationIcon = {
                        Button(onClick = { navigator.pop() }) { Text("← Back") }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
            ) {
                Text("Destination:", fontSize = 18.sp, color = MaterialTheme.colorScheme.secondary)
                Text(address, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(32.dp))

                // GPS Action Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isAtLocation) MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)
                        else MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = if (isAtLocation) "✅ You are at the location" else "❌ Not at location yet",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        // Fake GPS Trigger Button (Phase 6 UI)
                        Button(
                            onClick = { isAtLocation = !isAtLocation },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isAtLocation) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(if (isAtLocation) "Start Snow Removal" else "I Have Arrived (Mock GPS)")
                        }
                    }
                }
            }
        }
    }
}