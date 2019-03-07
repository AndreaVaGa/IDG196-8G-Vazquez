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

    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }
        }
    }

    @Test
    fun getAlumno(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/alumno").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getTutores(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/tutores").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getBoleta(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/boleta").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getAprobada(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/aprobada").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getPorCursar(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/porcursar").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun getHorario(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/horario").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
