package org.example.project.domain.models

data class SnowJob(
    val jobId: String,
    val address: String,
    val status: String,
    val clientName: String,
    val isSynced: Boolean = false
)