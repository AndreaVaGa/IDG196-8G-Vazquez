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

class LoginTest {
    private val getMatriculaQueryHandler = mockk<RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse>>()
    private val getPerfilQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetPerfilQueryResponse>>()
    private val getBoletaQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetBoletaQueryResponse>>()
    private val getHorarioQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetHorarioQueryResponse>>()
    private val getAprobadasQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetAprobadasQueryResponse>>()
    private val getPorCursarQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetPorCursarQueryResponse>>()
    private val getCursandoQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetCursandoQueryResponse>>()
    private val getTutoresQueryHandler = mockk<RequestHandler<GetTutoresQuery, GetTutoresQueryResponse>>()
    private val getPromedioGeneralQueryHandler =  mockk<RequestHandler<GetPromGeneralQuery, GetPromGeneralQueryResponse>>()
    private val saveFotoCommandHandler= mockk<RequestHandler<SaveFotoCommand, SaveFotoCommandResponse>>()
    private val saveColorCommandHandler= mockk<RequestHandler<SaveColorCommand, SaveColorCommandResponse>>()

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
    private val password = (0..10).random().toString()
    private val getMatriculaQueryResponse = GetMatriculaQueryResponse(matricula)


    @Before
    fun setup() {
        every { getMatriculaQueryHandler.handle(any()) } returns getMatriculaQueryResponse
    }


    @Test
    fun `calls query handler`() {
        api.getMatricula(AlumnoApi.GetMatriculaRequest(matricula, password))

        verify { getMatriculaQueryHandler.handle(any()) }
    }

    @Test
    fun `returns matricula correctly when login is correct`() {
        val request = GetMatriculaQuery(matricula, password)
        val expected = AlumnoApi.GetMatriculaResponse(request.matricula)

        every {
            getMatriculaQueryHandler.handle(request)
        } returns (GetMatriculaQueryResponse(request.matricula))

        val actual = api.getMatricula(AlumnoApi.GetMatriculaRequest(matricula, password))
        Assert.assertEquals(expected, actual)

        verify { getMatriculaQueryHandler.handle(request) }
    }

}