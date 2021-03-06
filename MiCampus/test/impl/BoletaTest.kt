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
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommand
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommandResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommand
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommandResponse
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQuery
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BoletaTest {
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
    private val saveColorCommandHandler = mockk<RequestHandler<SaveColorCommand, SaveColorCommandResponse>>()
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
        saveFotoCommandHandler,
        saveColorCommandHandler
    )

    private val matricula = (0..10).random().toString()

    private val cve_periodo = "ENE-JUN/2019"
    private val nombre_materia = "aplicaciones"
    private val nombre_maestro = "Angel Miguel Arambula"
    private val promedio = "0"
    private val faltas_totales = "1"
    private val calificacion1 = "0"
    private val calificacion2 = "10"
    private val calificacion3 = " "
    private val faltas1 = "0"
    private val faltas2 = "0"
    private val faltas3 = "0"
    private val faltas_tardias = "0"
    private val getBoletaQueryResponse = ArrayList<BoletaDTO>()
    private val boleta = BoletaDTO(
        cve_periodo,
        nombre_materia,
        nombre_maestro,
        promedio,
        faltas_totales,
        calificacion1,
        calificacion2,
        calificacion3,
        faltas1,
        faltas2,
        faltas3,
        faltas_tardias
    )


    @Before
    fun setup() {
        getBoletaQueryResponse.add(boleta)
        every { getBoletaQueryHandler.handle(any()) } returns GetBoletaQueryResponse(getBoletaQueryResponse)
    }

    @Test
    fun `calls boleta query handler`() {
        api.getBoleta(AlumnoApi.GetPerfilRequest(matricula))

        verify { getBoletaQueryHandler.handle(any()) }
    }

    @Test
    fun `returns boleta correctly when request is correct`() {
        val request = GetPerfilQuery(matricula)
        val expected = AlumnoApi.GetBoletaResponse(getBoletaQueryResponse)

        every {
            getBoletaQueryHandler.handle(request)
        } returns (GetBoletaQueryResponse(getBoletaQueryResponse))

        val actual = api.getBoleta(AlumnoApi.GetPerfilRequest(matricula))
        Assert.assertEquals(expected, actual)

        verify { getBoletaQueryHandler.handle(request) }
    }
}