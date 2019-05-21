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
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQuery
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import mx.edu.cetys.garay.andrea.dto.TutoresDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TutoresTest {
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

    private val nombre_1_padre = "Luis"
    private val nombre_2_padre = "Eduardo"
    private val apellido_paterno_padre = "Agundez"
    private val apellido_materno_padre = "Chahin"
    private val direccion_padre = "Priv. Colinas"
    private val colonia_padre = "Colinas de Agua Caliente"
    private val telefono_padre = "-"
    private val email_padre = "luis.eduardo@gmail.com"
    private val telefono_celular_pad = "(664) 557 8960"
    private val empresa_padre = "-"
    private val emp_dir_padre = "-"
    private val emp_col_padre = "-"
    private val emp_tel_padre = "-"
    private val nombre_1_madre = "Silvia"
    private val nombre_2_madre = ""
    private val apellido_paterno_madre = "Rodriguez"
    private val apellido_materno_madre = "Gamboa"
    private val direccion_madre = "Priv. Colinas"
    private val colonia_madre = "Colinas de Agua Caliente"
    private val telefono_madre = "-"
    private val email_madre = "silvia.rodriguez@gmail.com"
    private val telefono_celular_madre = "(664) 557 8960"
    private val empresa_madre = "-"
    private val emp_dir_madre = "-"
    private val emp_col_madre = "-"
    private val emp_tel_madre = "-"
    private val tutores = TutoresDTO(
        nombre_1_padre,
        nombre_2_padre,
        apellido_paterno_padre,
        apellido_materno_padre,
        direccion_padre,
        colonia_padre,
        telefono_padre,
        email_padre,
        telefono_celular_pad,
        empresa_padre,
        emp_dir_padre,
        emp_col_padre,
        emp_tel_padre,
        nombre_1_madre,
        nombre_2_madre,
        apellido_paterno_madre,
        apellido_materno_madre,
        direccion_madre,
        colonia_madre,
        telefono_madre,
        email_madre,
        telefono_celular_madre,
        empresa_madre,
        emp_dir_madre,
        emp_col_madre,
        emp_tel_madre
    )


    @Before
    fun setup() {
        every { getTutoresQueryHandler.handle(any()) } returns GetTutoresQueryResponse(nombre_1_padre, nombre_2_padre, apellido_paterno_padre, apellido_materno_padre, direccion_padre, colonia_padre, telefono_padre, email_padre, telefono_celular_pad, empresa_padre, emp_dir_padre, emp_col_padre, emp_tel_padre, nombre_1_madre, nombre_2_madre, apellido_paterno_madre, apellido_materno_madre, direccion_madre, colonia_madre, telefono_madre, email_madre, telefono_celular_madre, empresa_madre, emp_dir_madre, emp_col_madre, emp_tel_madre)
    }


    @Test
    fun `calls tutores query handler`() {
        api.getTutores(matricula)

        verify { getTutoresQueryHandler.handle(any()) }
    }

    @Test
    fun `returns tutores correctly when request is correct`() {
        val request = GetTutoresQuery(matricula)
        val expected = tutores

        every {
            getTutoresQueryHandler.handle(request)
        } returns (GetTutoresQueryResponse( nombre_1_padre, nombre_2_padre, apellido_paterno_padre, apellido_materno_padre, direccion_padre, colonia_padre, telefono_padre, email_padre, telefono_celular_pad, empresa_padre, emp_dir_padre, emp_col_padre, emp_tel_padre, nombre_1_madre, nombre_2_madre, apellido_paterno_madre, apellido_materno_madre, direccion_madre, colonia_madre, telefono_madre, email_madre, telefono_celular_madre, empresa_madre, emp_dir_madre, emp_col_madre, emp_tel_madre))

        val actual = api.getTutores(matricula)
        Assert.assertEquals(expected, actual)

        verify { getTutoresQueryHandler.handle(request) }
    }
}