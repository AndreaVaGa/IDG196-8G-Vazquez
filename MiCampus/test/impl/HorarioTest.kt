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
import mx.edu.cetys.garay.andrea.dto.HorarioDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HorarioTest {
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

    private val materia = "aplicaciones"
    private val maestro = "Angel Miguel Arambula"
    private val cve_periodo = "ENE-JUN/2019"
    private val dia = "lunes"
    private val lugar = "9005"
    private val hora_inicio = "6:00"
    private val hora_final = "8:00"
    private val color =" "
    private val getHorarioQueryResponse = ArrayList<HorarioDTO>()
    private val horario = HorarioDTO(
        materia,
        maestro,
        cve_periodo,
        dia,
        lugar,
        hora_inicio,
        hora_final,
        color
    )


    @Before
    fun setup() {
        getHorarioQueryResponse.add(horario)
        every { getHorarioQueryHandler.handle(any()) } returns GetHorarioQueryResponse(getHorarioQueryResponse)
    }

    @Test
    fun `calls horario query handler`() {
        api.getHorario(matricula)

        verify { getHorarioQueryHandler.handle(any()) }
    }

    @Test
    fun `returns horario correctly when request is correct`() {
        val request = GetPerfilQuery(matricula)
        val expected = AlumnoApi.GetHorarioResponse(getHorarioQueryResponse)

        every {
            getHorarioQueryHandler.handle(request)
        } returns (GetHorarioQueryResponse(getHorarioQueryResponse))

        val actual = api.getHorario(matricula)
        Assert.assertEquals(expected, actual)

        verify { getHorarioQueryHandler.handle(request) }
    }
}