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
    fun GetBoleta() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/get/boleta").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun GetTutores() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/mc/get/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
