package mx.edu.cetys.garay.andrea

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQuery
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryHandler
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse


class AlumnoApi(
    private val getMatriculaQueryHandler: RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse>,
    private val getPerfilQueryHandler: RequestHandler<GetPerfilQuery, GetPerfilQueryResponse>,
    private val getBoletaQueryHandler: RequestHandler<GetPerfilQuery, GetBoletaQueryResponse>
) {

    fun getMatricula(matricula: String, password: String): GetMatriculaResponse {
        val response = getMatriculaQueryHandler.handle(GetMatriculaQuery(matricula, password))
        return GetMatriculaResponse(response.matricula)
    }

    fun getPerfil(matricula: String): PerfilDTO {
        val response = getPerfilQueryHandler.handle(GetPerfilQuery(matricula))
        return PerfilDTO(
            response.matricula,
            response.nombre_1,
            response.nombre_2,
            response.apellido_paterno,
            response.apellido_materno,
            response.nombre_programa,
            response.cve_programa,
            response.materias_aprobadas
        )

    }

    fun getBoleta(matricula: String):GetBoletaResponse{
        val response = getBoletaQueryHandler.handle(GetPerfilQuery(matricula))
        return GetBoletaResponse(response.boleta)
    }

    data class GetMatriculaResponse(val matricula: String)
    data class GetBoletaResponse(val boleta: List<BoletaDTO>)
}