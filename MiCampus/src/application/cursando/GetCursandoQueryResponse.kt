package mx.edu.cetys.garay.andrea.application.cursando

data class GetCursandoQueryResponse(
    val cve_periodo : String,
    val nombre_materia:String,
    val nombre_maestro: String,
    val  horas_clase: String
)