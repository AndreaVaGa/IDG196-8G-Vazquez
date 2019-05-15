package mx.edu.cetys.garay.andrea.impl

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mx.edu.cetys.garay.andrea.AlumnoApi
import mx.edu.cetys.garay.andrea.BoletaDTO
import mx.edu.cetys.garay.andrea.PerfilDTO
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
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PerfilTest {
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

    private val nombre_1 = "aplicaciones"
    private val nombre_2 = "Angel Miguel Arambula"
    private val apellido_paterno = "0"
    private val apellido_materno = "1"
    private val nombre_programa = "0"
    private val cve_programa = "10"
    private val materias_aprobadas = " "
    private val foto_portada = "a"
    private val perfil = PerfilDTO(
        matricula,
        nombre_1,
        nombre_2,
        apellido_paterno,
        apellido_materno,
        nombre_programa,
        cve_programa,
        materias_aprobadas,
        foto_portada
    )


    @Before
    fun setup() {
        every { getPerfilQueryHandler.handle(any()) } returns GetPerfilQueryResponse(
            matricula,
            nombre_1,
            nombre_2,
            apellido_paterno,
            apellido_materno,
            nombre_programa,
            cve_programa,
            materias_aprobadas,
            foto_portada
        )
    }


    @Test
    fun `calls perfil query handler`() {
        api.getPerfil(AlumnoApi.GetPerfilRequest(matricula))

        verify { getPerfilQueryHandler.handle(any()) }
    }

    @Test
    fun `returns perfil correctly when request is correct`() {
        val request = GetPerfilQuery(matricula)
        val expected = perfil

        every {
            getPerfilQueryHandler.handle(request)
        } returns (GetPerfilQueryResponse(
            matricula,
            nombre_1,
            nombre_2,
            apellido_paterno,
            apellido_materno,
            nombre_programa,
            cve_programa,
            materias_aprobadas,
            foto_portada
            ))

        val actual = api.getPerfil(AlumnoApi.GetPerfilRequest(matricula))
        Assert.assertEquals(expected, actual)

        verify { getPerfilQueryHandler.handle(request) }
    }
}