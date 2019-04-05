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
    fun getAlumno(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/buscarAlumno?matricula=021204&password=123456").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getTutores(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/Tutores?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getBoleta(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/Boleta?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getAprobada(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/Aprobadas?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


    @Test
    fun getHorario(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/Horario?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPerfil(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/Perfil?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getCursando(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/Cursando?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPromedioGeneral(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/PromedioGeneral?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPorCursar(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/PorCursar?matricula=021204").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
