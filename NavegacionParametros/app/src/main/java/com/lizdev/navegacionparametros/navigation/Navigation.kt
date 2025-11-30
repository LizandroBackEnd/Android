package com.lizdev.navegacionparametros.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home
@Serializable
data class Detail(val id: Int, val opcional: String)