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
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQuery
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import mx.edu.cetys.garay.andrea.dto.AprobadasDTO
import mx.edu.cetys.garay.andrea.dto.PorCursarDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PorCursarTest {
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
    private val api = AlumnoApi(
        getMatriculaQueryHandler,
        getPerfilQueryHandler,
        getBoletaQueryHandler,
        getHorarioQueryHandler,
        getAprobadasQueryHandler,
        getPorCursarQueryHandler,
        getCursandoQueryHandler,
        getTutoresQueryHandler,
        getPromedioGeneralQueryHandler
    )

    private val matricula = (0..10).random().toString()

    private val nombre_materia = "aplicaciones"
    private val horas_clase = "8"
    private val cve_materia = "15"
    private val cve_plandeestudio = "1"
    private val getPorCursarQueryResponse = ArrayList<PorCursarDTO>()
    private val porCursar = PorCursarDTO(
        nombre_materia,
        horas_clase,
        cve_materia,
        cve_plandeestudio
    )


    @Before
    fun setup() {
        getPorCursarQueryResponse.add(porCursar)
        every { getPorCursarQueryHandler.handle(any()) } returns GetPorCursarQueryResponse(getPorCursarQueryResponse)
    }

    @Test
    fun `calls por cursar query handler`() {
        api.getPorCursar(matricula)

        verify { getPorCursarQueryHandler.handle(any()) }
    }

    @Test
    fun `returns por cursar correctly when request is correct`() {
        val request = GetPerfilQuery(matricula)
        val expected = AlumnoApi.GetPorCursarResponse(getPorCursarQueryResponse)

        every {
            getPorCursarQueryHandler.handle(request)
        } returns (GetPorCursarQueryResponse(getPorCursarQueryResponse))

        val actual = api.getPorCursar(matricula)
        Assert.assertEquals(expected, actual)

        verify { getPorCursarQueryHandler.handle(request) }
    }
}