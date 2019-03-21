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
import mx.edu.cetys.garay.andrea.exposed.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "/api/micampus"
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

        get("$apiRoot/public/v1/alumnos/buscarAlumno") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""
            val password = queryParameters["password"] ?: ""

            val alumno = callBuscarAlumnoSP(matricula, password)
            call.respond(alumno)
        }
        get("$apiRoot/public/v1/alumnos/buscarPerfil") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val perfil = callBuscarPerfilSP(matricula)
            call.respond(perfil)
        }
        get("$apiRoot/public/v1/alumnos/buscarBoleta") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val boleta = callBuscarBoletaSP(matricula)
            call.respond(boleta)
        }

        get("$apiRoot/public/v1/alumnos/buscarCursando") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val cursando = callBuscarCursandoSP(matricula)
            call.respond(cursando)
        }
        get("$apiRoot/public/v1/alumnos/buscarHorario") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val horario = callBuscarHorarioSP(matricula)
            call.respond(horario)
        }
        get("$apiRoot/public/v1/alumnos/buscarAprobadas") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val aprobadas = callBuscarAprobadasSP(matricula)
            call.respond(aprobadas)
        }
        get("$apiRoot/public/v1/alumnos/buscarTutores") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val tutores = callBuscarTutoresSP(matricula)
            call.respond(tutores)
        }





    }
}

