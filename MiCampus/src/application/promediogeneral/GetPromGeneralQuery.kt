package mx.edu.cetys.garay.andrea.application.promediogeneral

import mx.edu.cetys.garay.andrea.application.Request

data class GetPromGeneralQuery(
    val matricula: String
) : Request