package mx.edu.cetys.garay.andrea.application.perfiles

data class GetPerfilQueryResponse(
    val matricula: String,
    val nombre_1: String,
    val nombre_2: String,
    val apellido_paterno: String,
    val apellido_materno: String,
    val nombre_programa: String,
    val cve_programa: String,
    val materias_aprobadas: String,
    val foto_portada: String
)
