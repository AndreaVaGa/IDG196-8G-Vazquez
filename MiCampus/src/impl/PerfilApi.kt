package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryHandler


class PerfilApi {
    private val getPerfilQueryHandler = GetPerfilQueryHandler()

    fun getPerfil(matricula: String): GetPerfilResponse {
        val response = getPerfilQueryHandler.handle(GetPerfilQuery(matricula))
        return GetPerfilResponse(
            response.matricula,
            response.nombre_1,
            response.nombre_2,
            response.apellido_paterno,
            response.apellido_materno,
            response.nombre_programa,
            response.cve_programa,
            response.materias_aprobadas)
    }

    data class GetPerfilResponse(
        val matricula: String,
        val nombre_1: String,
        val nombre_2: String,
        val apellido_paterno: String,
        val apellido_materno: String,
        val nombre_programa: String,
        val cve_programa: String,
        val materias_aprobadas: String
    )
}