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
import mx.edu.cetys.garay.andrea.impl.PerfilApi


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "/api/micampus"
    val alumnoApi = AlumnoApi()
    val perfilApi = PerfilApi()
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

            val response = alumnoApi.getMatricula(matricula, password)

            call.respond(response)
        }
        get("$apiRoot/public/v1/alumnos/buscarPerfil") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""
            val response = perfilApi.getPerfil(matricula)
            call.respond(response)
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
        get("$apiRoot/public/v1/alumnos/buscarPorCursar") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val porcursar = callBuscarPorCursarSP(matricula)
            call.respond(porcursar)
        }
        get("$apiRoot/public/v1/alumnos/buscarPromedioGeneral") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val promediogeneral = callBuscarPromedioGeneralSP(matricula)
            call.respond(promediogeneral)
        }

    }
}

