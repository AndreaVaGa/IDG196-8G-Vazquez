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

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Authentication) {
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(CORS) {
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
        get("/mc/alumno") {
            call.respond(
                mapOf(
                    "Nombre_1" to "Andrea" ,
                            "Nombre_2" to "" ,
                            "Matricula" to "021204" ,
                            "Apellido_Paterno" to "Vazquez" ,
                            "Apellido_Materno" to "Garay" ,
                            "Nombre_Programa" to "IDGD" ,
                            "materias_aprobadas" to "48"
                )
            )
        }
        get("/mc/boleta") {
            call.respond(mapOf("boleta" to "x"))
        }
        get("/mc/tutores") {
            call.respond(mapOf("tutor" to "Armando"))
        }
    }
}

