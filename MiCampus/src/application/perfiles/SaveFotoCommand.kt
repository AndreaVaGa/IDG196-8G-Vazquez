package mx.edu.cetys.garay.andrea.application.perfiles

import mx.edu.cetys.garay.andrea.application.Request

data class SaveFotoCommand(
    val matricula: String,
    val foto_portada: String
) : Request