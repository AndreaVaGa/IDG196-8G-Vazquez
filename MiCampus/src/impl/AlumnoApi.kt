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
import mx.edu.cetys.garay.andrea.application.perfiles.*
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryHandler
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
    private val saveFotoCommandHandler: RequestHandler<SaveFotoCommand, SaveFotoCommandResponse>
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
            response.materias_aprobadas,
            response.foto_portada
        )

    }

    fun getTutores(matricula: String): TutoresDTO {
        val response = getTutoresQueryHandler.handle(GetTutoresQuery(matricula))
        return TutoresDTO(
            response.nombre_1_padre,
            response.nombre_2_padre,
            response.apellido_paterno_padre,
            response.apellido_materno_padre,
            response.direccion_padre,
            response.colonia_padre,
            response.telefono_padre,
            response.email_padre,
            response.telefono_celular_pad,
            response.empresa_padre,
            response.emp_dir_padre,
            response.emp_col_padre,
            response.emp_tel_padre,
            response.nombre_1_madre,
            response.nombre_2_madre,
            response.apellido_paterno_madre,
            response.apellido_materno_madre,
            response.direccion_madre,
            response.colonia_madre,
            response.telefono_madre,
            response.email_madre,
            response.telefono_celular_madre,
            response.empresa_madre,
            response.emp_dir_madre,
            response.emp_col_madre,
            response.emp_tel_madre
        )

    }

    fun getPromedioGeneral(matricula: String): PromedioGeneralDTO {
        val response = getPromedioGeneralQueryHandler.handle(GetPromGeneralQuery(matricula))
        return PromedioGeneralDTO(
            response.promedio_general
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

    fun getCursando(matricula: String):GetCursandoResponse{
        val response = getCursandoQueryHandler.handle(GetPerfilQuery(matricula))
        return GetCursandoResponse(response.cursando)
    }
    fun changeFoto(request: SaveFotoCommand): saveFotoCommandResponse{
        val response = saveFotoCommandHandler.handle(SaveFotoCommand(request.matricula,request.foto))
        return saveFotoCommandResponse(response)

    }


    data class GetMatriculaResponse(val matricula: String)
    data class GetBoletaResponse(val boleta: List<BoletaDTO>)
    data class GetHorarioResponse(val horario: List<HorarioDTO>)
    data class GetAprobadasResponse(val aprobadas: List<AprobadasDTO>)
    data class GetPorCursarResponse(val porcursar: List<PorCursarDTO>)
    data class GetCursandoResponse(val cursando: List<CursandoDTO>)
    data class saveFotoCommandResponse(val perfil: SaveFotoCommandResponse)
}