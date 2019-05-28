package mx.edu.cetys.garay.andrea

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQuery
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQuery
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryResponse
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryResponse
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryResponse
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommand
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommandResponse
import mx.edu.cetys.garay.andrea.application.perfiles.*
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQuery
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import mx.edu.cetys.garay.andrea.dto.*


class AlumnoApi(
    private val getMatriculaQueryHandler: RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse>,
    private val getPerfilQueryHandler: RequestHandler<GetPerfilQuery, GetPerfilQueryResponse>,
    private val getBoletaQueryHandler: RequestHandler<GetPerfilQuery, GetBoletaQueryResponse>,
    private val getHorarioQueryHandler: RequestHandler<GetPerfilQuery, GetHorarioQueryResponse>,
    private val getAprobadasQueryHandler: RequestHandler<GetPerfilQuery, GetAprobadasQueryResponse>,
    private val getPorCursarQueryHandler: RequestHandler<GetPerfilQuery, GetPorCursarQueryResponse>,
    private val getCursandoQueryHandler: RequestHandler<GetPerfilQuery, GetCursandoQueryResponse>,
    private val getTutoresQueryHandler: RequestHandler<GetTutoresQuery, GetTutoresQueryResponse>,
    private val getPromedioGeneralQueryHandler: RequestHandler<GetPromGeneralQuery, GetPromGeneralQueryResponse>,
    private val saveFotoCommandHandler: RequestHandler<SaveFotoCommand, SaveFotoCommandResponse>,
    private val saveColorCommandHandler: RequestHandler<SaveColorCommand, SaveColorCommandResponse>
) {

    fun getMatricula(request: GetMatriculaRequest): GetMatriculaResponse {
        val response = getMatriculaQueryHandler.handle(GetMatriculaQuery(request.matricula, request.password))
        return GetMatriculaResponse(response.matricula)
    }

    fun getPerfil(request: GetPerfilRequest): GetPerfilResponse {
        val response = getPerfilQueryHandler.handle(GetPerfilQuery(request.matricula))
        return GetPerfilResponse(response.perfil)
    }

    fun getTutores(request: GetPerfilRequest): GetTutoresResponse {
        val response = getTutoresQueryHandler.handle(GetTutoresQuery(request.matricula))
        return GetTutoresResponse(response)
    }

    fun getPromedioGeneral(request: GetPerfilRequest): PromedioGeneralDTO {
        val response = getPromedioGeneralQueryHandler.handle(GetPromGeneralQuery(request.matricula))
        return PromedioGeneralDTO(
            response.promedio_general
        )
    }

    fun getBoleta(request: GetPerfilRequest): GetBoletaResponse {
        val response = getBoletaQueryHandler.handle(GetPerfilQuery(request.matricula))
        return GetBoletaResponse(response.boleta)
    }

    fun getHorario(request: GetPerfilRequest): GetHorarioResponse {
        val response = getHorarioQueryHandler.handle(GetPerfilQuery(request.matricula))
        return GetHorarioResponse(response.horario)
    }

    fun getAprobadas(request: GetPerfilRequest): GetAprobadasResponse {
        val response = getAprobadasQueryHandler.handle(GetPerfilQuery(request.matricula))
        return GetAprobadasResponse(response.aprobadas)
    }

    fun getPorCursar(request: GetPerfilRequest): GetPorCursarResponse {
        val response = getPorCursarQueryHandler.handle(GetPerfilQuery(request.matricula))
        return GetPorCursarResponse(response.porcursar)
    }

    fun getCursando(request: GetPerfilRequest): GetCursandoResponse {
        val response = getCursandoQueryHandler.handle(GetPerfilQuery(request.matricula))
        return GetCursandoResponse(response.cursando)
    }

    fun cambiarFoto(request: SaveFotoRequest): saveFotoResponse {
        val response = saveFotoCommandHandler.handle(SaveFotoCommand(request.matricula, request.foto_portada))
        return saveFotoResponse(response)

    }

    fun cambiarColor(request: SaveColorRequest): GetHorarioResponse {
        val response =
            saveColorCommandHandler.handle(SaveColorCommand(request.matricula, request.materia, request.color))
        return GetHorarioResponse(response.horario)
    }

    data class GetMatriculaRequest(
        val matricula: String,
        val password: String
    )

    data class SaveFotoRequest(
        val matricula: String,
        val foto_portada: String
    )

    data class GetPerfilRequest(val matricula: String)
    data class SaveColorRequest(val matricula: String, val materia: String, val color: String)
    data class GetMatriculaResponse(val matricula: String)
    data class GetTutoresResponse(val tutores: GetTutoresQueryResponse)
    data class GetBoletaResponse(val boleta: List<BoletaDTO>)
    data class GetHorarioResponse(val horario: List<HorarioDTO>)
    data class GetAprobadasResponse(val aprobadas: List<AprobadasDTO>)
    data class GetPorCursarResponse(val porcursar: List<PorCursarDTO>)
    data class GetCursandoResponse(val cursando: List<CursandoDTO>)
    data class GetPerfilResponse(val perfil: PerfilDTO)
    data class saveFotoResponse(val perfil: SaveFotoCommandResponse)
}