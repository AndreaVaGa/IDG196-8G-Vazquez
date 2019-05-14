package mx.edu.cetys.garay.andrea.dto

data class HorarioDTO (
    val materia: String,
    val maestro: String,
    val cve_periodo: String,
    val dia: String,
    val lugar: String,
    val hora_inicio: String,
    val hora_final: String,
    val color: String
)