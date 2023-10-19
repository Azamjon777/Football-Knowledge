package com.daz.footballknowledge.presentation.model

import java.io.Serializable

data class QuestionCategory(
    val sportName: String,
    val list: List<Questions>
) : Serializable