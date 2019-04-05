package mx.edu.cetys.garay.andrea.application.aprobadas

data class GetAprobadasQueryResponse (
    val cve_periodo : String,
    val nombre_materia:String,
    val nombre_maestro: String,
    val horas_clase: String,
    val calificacion_final: String
)
