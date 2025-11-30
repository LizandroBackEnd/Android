package com.lizdev.articulos.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ArticuloViewModel : ViewModel() {
    private val _articulos = mutableStateListOf<Articulo>()
    val articulos: List<Articulo> get() = _articulos

    fun agregarArticulo(nombre: String, precio: Double, stock: Int, activo: Boolean) {
        val nuevo = Articulo(
            id = _articulos.size + 1,
            nombre = nombre,
            precio = precio,
            stock = stock,
            categoria = "General",
            activo = activo
        )
        _articulos.add(nuevo)
    }

    fun venderArticulo(id: Int, cantidad: Int) {
        val index = _articulos.indexOfFirst { it.id == id }
        if (index != -1) {
            val articulo = _articulos[index]
            val nuevoStock = articulo.stock - cantidad
            if (nuevoStock > 0) {
                _articulos[index] = articulo.copy(stock = nuevoStock)
            } else {
                _articulos.removeAt(index)
            }
        }
    }

    fun eliminarArticulo(id: Int) {
        _articulos.removeAll { it.id == id }
    }
}
