package mx.edu.cetys.garay.andrea.dto

data class CompraDTO(
    val id_compra: Int,
    val matricula: String,
    val date: String,
    val id_tramite: Int,
    val tramite: String,
    val precio: Int,
    val total: Int
)