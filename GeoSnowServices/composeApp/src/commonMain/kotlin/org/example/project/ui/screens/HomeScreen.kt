package org.example.project.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

// Dummy Data Class UI ke liye
data class DummyJob(val id: String, val address: String, val client: String, val isSynced: Boolean)

class HomeScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        // Dummy list for UI testing
        val dummyJobs = listOf(
            DummyJob("101", "123 Main St, New York", "John Doe", true),
            DummyJob("102", "456 Wall St, New York", "Jane Smith", false),
            DummyJob("103", "789 Broadway, New York", "Ali Khan", true)
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Pending Jobs", fontWeight = FontWeight.Bold) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(dummyJobs) { job ->
                    JobCard(job) {
                        // Card par click karne se Job Details par jayenge
                        navigator.push(JobDetailScreen(job.address))
                    }
                }
            }
        }
    }
}

@Composable
fun JobCard(job: DummyJob, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = job.client, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                // Sync Indicator
                Text(
                    text = if (job.isSynced) "Synced ☁️" else "Offline 📁",
                    color = if (job.isSynced) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "📍 ${job.address}", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}