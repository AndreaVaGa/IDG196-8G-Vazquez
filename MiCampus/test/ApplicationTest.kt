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
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/login?password=123456").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getTutores(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Tutores").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getBoleta(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Boleta").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getAprobada(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Aprobadas").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


    @Test
    fun getHorario(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Horario").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPerfil(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Perfil").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getCursando(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/Cursando").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPromedioGeneral(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/PromedioGeneral").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPorCursar(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "$apiRoot/public/v1/alumnos/T021204/PorCursar").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
