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
    fun testCustomer(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/shoppingCart/customer").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
    @Test
    fun testProducts(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/shoppingCart/products").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
    @Test
    fun testTotal(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/shoppingCart/total").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
    @Test
    fun testPayments(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/customer/payments").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


}
