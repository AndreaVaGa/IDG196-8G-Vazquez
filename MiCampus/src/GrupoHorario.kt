package mx.edu.cetys.garay.andrea

data class GrupoHorario (
    val cve_periodo: String,
    val dia: String,
    val hora_inicio: String,
    val hora_final: String,
    val materia: Materia
)