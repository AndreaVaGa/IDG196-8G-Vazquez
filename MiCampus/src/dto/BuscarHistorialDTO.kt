package mx.edu.cetys.garay.andrea.dto

import org.joda.time.DateTime

data class HistorialDTO(
    val id_compras: Int,
    val date: String,
    val id_tramites: Int,
    val name: String,
    val price: Int
)