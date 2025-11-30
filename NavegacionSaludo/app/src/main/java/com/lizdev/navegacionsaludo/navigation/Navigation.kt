package com.lizdev.navegacionsaludo.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home
@Serializable
data class GetDates(val name: String, val age: Int)