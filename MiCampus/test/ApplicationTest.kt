package mx.edu.cetys.garay.andrea

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    val apiRoot = "/api/micampus"

    @Test
    fun getAlumno() {
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"021204\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getTutores() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/tutores").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getBoleta() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/boleta").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getAprobada() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(
                HttpMethod.Get,
                "$apiRoot/public/v1/alumnos/T021204/historial/academico/materias/aprobadas"
            ).apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


    @Test
    fun getHorario() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/horario").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPerfil() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/perfil").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getCursando() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(
                HttpMethod.Get,
                "$apiRoot/public/v1/alumnos/T021204/historial/academico/materias/cursando"
            ).apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPromedioGeneral() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(
                HttpMethod.Get,
                "$apiRoot/public/v1/alumnos/T021204/historial/academico/promedioGeneral"
            ).apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPorCursar() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(
                HttpMethod.Get,
                "$apiRoot/public/v1/alumnos/T021204/historial/academico/materias/porCursar"
            ).apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getMatriculaConT(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"T021204\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getMatriculaConE(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"E021204\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getMatriculaConM(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"M021204\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
    @Test
    fun addFoto() {
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Put, "$apiRoot/public/v1/alumnos/T021204/perfil") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"021204\",\"foto_portada\":\"b\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
    @Test
    fun addColor() {
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Put, "$apiRoot/public/v1/alumnos/T021204/horario") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"021204\",\"materia\":\"Base de Datos\",\"color\":\"#F9F4BB\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
    @Test
    fun addCompra() {
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1//alumnos/T021204/historial/financiero") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"021204\",\"tramites\":\"1,3,5,\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


    @Test
    fun getMatriculaEspaciosBlancos(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"02 1204 \",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.NotFound, response.status())
            }
        }
    }

    @Test
    fun getMatriculaMasNumeros(){
        withTestApplication({ module(testing = false) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"021204122\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getMatriculaMenosNumeros(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"02120\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.NotFound, response.status())
            }
        }
    }

    @Test
    fun getMatriculaCaracteresEspeciales(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"02120@#\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.NotFound, response.status())
            }
        }
    }

    @Test
    fun getMatriculaBoolean(){
        withTestApplication({ module(testing = true) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"return\",\"password\":\"123456\"}")
            }) {
                assertEquals(HttpStatusCode.NotFound, response.status())
            }
        }
    }

    @Test
    fun getPasswordEspaciosBlancos(){
        withTestApplication({ module(testing = false) }) {
            with(handleRequest(HttpMethod.Post, "$apiRoot/public/v1/alumnos/login") {
                addHeader("content-type", "application/json")
                setBody("{\"matricula\":\"021204\",\"password\":\"123456 \"}")
            }) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

}
