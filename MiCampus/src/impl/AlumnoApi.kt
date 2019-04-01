package mx.edu.cetys.garay.andrea

import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQuery
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryHandler


class AlumnoApi{
    private val getMatriculaQueryHandler = GetMatriculaQueryHandler()

    fun getMatricula(matricula: String, password: String): GetMatriculaResponse {
        val response = getMatriculaQueryHandler.handle(GetMatriculaQuery(matricula, password))
        return GetMatriculaResponse(response.matricula)
    }

    data class GetMatriculaResponse(val matricula: String)
}