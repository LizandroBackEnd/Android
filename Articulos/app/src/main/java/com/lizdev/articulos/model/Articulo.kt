package com.lizdev.articulos.model

import kotlinx.serialization.Serializable


@Serializable
data class Articulo(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int,
    val categoria: String,
    val activo: Boolean
)