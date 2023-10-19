package com.daz.footballknowledge.presentation.model

import java.io.Serializable

data class Questions(
    val questions: String,
    val answers: List<String>,
    val correctAnswer: String
) : Serializable
