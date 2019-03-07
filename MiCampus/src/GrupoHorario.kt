package mx.edu.cetys.garay.andrea

data class GrupoHorario (
    val Cve_Periodo: String,
    val Dia: String,
    val Hora_Inicio: String,
    val Hora_Final: String,
    val Materia: Materia
)