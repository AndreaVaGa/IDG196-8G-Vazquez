package mx.edu.cetys.garay.andrea.application.Tutores

import mx.edu.cetys.garay.andrea.application.Request

data class GetTutoresQuery(
    val matricula: String
) : Request