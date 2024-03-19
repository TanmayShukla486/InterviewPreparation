package com.example.bizcard.ui.screens

import com.example.bizcard.R
import java.util.UUID

data class ProjectItem (
    val name: String,
    val link: String,
    val image: Int,
    val desc: String,
    val projectId: UUID = UUID.randomUUID()
)
