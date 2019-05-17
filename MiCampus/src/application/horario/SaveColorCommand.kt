package mx.edu.cetys.garay.andrea.application.horario

import mx.edu.cetys.garay.andrea.application.Request

data class SaveColorCommand(
    val matricula: String,
    val materia: String,
    val color: String
) : Request