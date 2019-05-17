package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.application.Request

data class GetReciboQuery(
    val matricula: String,
    val id_compra: Int
) : Request