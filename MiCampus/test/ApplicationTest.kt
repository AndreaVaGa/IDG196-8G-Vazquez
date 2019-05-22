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
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Tutores").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getBoleta() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Boleta").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getAprobada() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(
                HttpMethod.Get,
                "$apiRoot/public/v1/alumnos/T021204/Historial/Academico/Materias/Aprobadas"
            ).apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


    @Test
    fun getHorario() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Horario").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPerfil() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Perfil").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getCursando() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(
                HttpMethod.Get,
                "$apiRoot/public/v1/alumnos/T021204/Historial/Academico/Materias/Cursando"
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
                "$apiRoot/public/v1/alumnos/T021204/Historial/Academico/PromedioGeneral"
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
                "$apiRoot/public/v1/alumnos/T021204/Historial/Academico/Materias/PorCursar"
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

}
