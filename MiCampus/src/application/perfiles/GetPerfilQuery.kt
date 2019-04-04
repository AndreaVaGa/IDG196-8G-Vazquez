package mx.edu.cetys.garay.andrea.application.perfiles

import mx.edu.cetys.garay.andrea.application.Request

data class GetPerfilQuery(
    val matricula: String
) : Request