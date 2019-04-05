package mx.edu.cetys.garay.andrea.application.porcursar

data class GetPorCursarQueryResponse(
    val nombre_materia: String,
    val horas_clase: String,
    val cve_materia:String,
    val cve_planestudio: String
)