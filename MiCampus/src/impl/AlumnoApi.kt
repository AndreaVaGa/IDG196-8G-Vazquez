package mx.edu.cetys.garay.andrea

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQuery
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryResponse
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryHandler
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.dto.AprobadasDTO
import mx.edu.cetys.garay.andrea.dto.HorarioDTO
import mx.edu.cetys.garay.andrea.dto.PorCursarDTO


class AlumnoApi(
    private val getMatriculaQueryHandler: RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse>,
    private val getPerfilQueryHandler: RequestHandler<GetPerfilQuery, GetPerfilQueryResponse>,
    private val getBoletaQueryHandler: RequestHandler<GetPerfilQuery, GetBoletaQueryResponse>,
    private val getHorarioQueryHandler: RequestHandler<GetPerfilQuery, GetHorarioQueryResponse>,
    private val getAprobadasQueryHandler: RequestHandler<GetPerfilQuery, GetAprobadasQueryResponse>,
    private val getPorCursarQueryHandler: RequestHandler<GetPerfilQuery, GetPorCursarQueryResponse>
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

    fun getHorario(matricula: String):GetHorarioResponse{
        val response = getHorarioQueryHandler.handle(GetPerfilQuery(matricula))
        return GetHorarioResponse(response.horario)
    }

    fun getAprobadas(matricula: String):GetAprobadasResponse{
        val response = getAprobadasQueryHandler.handle(GetPerfilQuery(matricula))
        return GetAprobadasResponse(response.aprobadas)
    }

    fun getPorCursar(matricula: String):GetPorCursarResponse{
        val response = getPorCursarQueryHandler.handle(GetPerfilQuery(matricula))
        return GetPorCursarResponse(response.porcursar)
    }


    data class GetMatriculaResponse(val matricula: String)
    data class GetBoletaResponse(val boleta: List<BoletaDTO>)
    data class GetHorarioResponse(val horario: List<HorarioDTO>)
    data class GetAprobadasResponse(val aprobadas: List<AprobadasDTO>)
    data class GetPorCursarResponse(val porcursar: List<PorCursarDTO>)
}