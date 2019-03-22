package mx.edu.cetys.garay.andrea

data class BoletaDTO(
    val cve_periodo: String,
    val nombre_materia: String,
    val nombre_maestro: String,
    val promedio: String,
    val faltas_totales: String,
    val calificacion1: String,
    val calificacion2: String,
    val calificacion3: String,
    val faltas1: String,
    val faltas2: String,
    val faltas3: String,
    val faltas_tardias: String
)