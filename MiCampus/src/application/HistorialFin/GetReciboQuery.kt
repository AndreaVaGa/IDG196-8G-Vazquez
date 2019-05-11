package mx.edu.cetys.garay.andrea.application.HistorialFin

import mx.edu.cetys.garay.andrea.application.Request

data class GetReciboQuery(
    val matricula: String
) : Request