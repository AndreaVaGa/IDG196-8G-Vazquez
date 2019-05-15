package mx.edu.cetys.garay.andrea.impl

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mx.edu.cetys.garay.andrea.AlumnoApi
import mx.edu.cetys.garay.andrea.BoletaDTO
import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQuery
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQuery
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryResponse
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryResponse
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommand
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommandResponse
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQuery
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import mx.edu.cetys.garay.andrea.dto.AprobadasDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AprobadasTest {
    private val getMatriculaQueryHandler = mockk<RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse>>()
    private val getPerfilQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetPerfilQueryResponse>>()
    private val getBoletaQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetBoletaQueryResponse>>()
    private val getHorarioQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetHorarioQueryResponse>>()
    private val getAprobadasQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetAprobadasQueryResponse>>()
    private val getPorCursarQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetPorCursarQueryResponse>>()
    private val getCursandoQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetCursandoQueryResponse>>()
    private val getTutoresQueryHandler = mockk<RequestHandler<GetTutoresQuery, GetTutoresQueryResponse>>()
    private val getPromedioGeneralQueryHandler =
        mockk<RequestHandler<GetPromGeneralQuery, GetPromGeneralQueryResponse>>()
    private val saveFotoCommandHandler = mockk<RequestHandler<SaveFotoCommand, SaveFotoCommandResponse>>()
    private val api = AlumnoApi(
        getMatriculaQueryHandler,
        getPerfilQueryHandler,
        getBoletaQueryHandler,
        getHorarioQueryHandler,
        getAprobadasQueryHandler,
        getPorCursarQueryHandler,
        getCursandoQueryHandler,
        getTutoresQueryHandler,
        getPromedioGeneralQueryHandler,
        saveFotoCommandHandler
    )

    private val matricula = (0..10).random().toString()

    private val cve_periodo = "ENE-JUN/2019"
    private val nombre_materia = "aplicaciones"
    private val nombre_maestro = "Angel Miguel Arambula"
    private val horas_clase = "8"
    private val calificacion_final = "80"
    private val getAprobadasQueryResponse = ArrayList<AprobadasDTO>()
    private val aprobadas = AprobadasDTO(
        cve_periodo,
        nombre_materia,
        nombre_maestro,
        horas_clase,
        calificacion_final
    )


    @Before
    fun setup() {
        getAprobadasQueryResponse.add(aprobadas)
        every { getAprobadasQueryHandler.handle(any()) } returns GetAprobadasQueryResponse(getAprobadasQueryResponse)
    }

    @Test
    fun `calls aprobadas query handler`() {
        api.getAprobadas(AlumnoApi.GetPerfilRequest(matricula))

        verify { getAprobadasQueryHandler.handle(any()) }
    }

    @Test
    fun `returns aprobadas correctly when request is correct`() {
        val request = GetPerfilQuery(matricula)
        val expected = AlumnoApi.GetAprobadasResponse(getAprobadasQueryResponse)

        every {
            getAprobadasQueryHandler.handle(request)
        } returns (GetAprobadasQueryResponse(getAprobadasQueryResponse))

        val actual = api.getAprobadas(AlumnoApi.GetPerfilRequest(matricula))
        Assert.assertEquals(expected, actual)

        verify { getAprobadasQueryHandler.handle(request) }
    }
}