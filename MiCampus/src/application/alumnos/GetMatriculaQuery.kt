package mx.edu.cetys.garay.andrea.application.alumnos

import mx.edu.cetys.garay.andrea.application.Request


data class GetMatriculaQuery(
    val matricula: String,
    val password: String
) : Request