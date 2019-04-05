package mx.edu.cetys.garay.andrea

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import mx.edu.cetys.garay.andrea.exposed.*
import mx.edu.cetys.garay.andrea.impl.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "/api/micampus"
    val alumnoApi = AlumnoApi()
    val perfilApi = PerfilApi()
    val boletaApi = BoletaApi()
    val tutoresApi = TutoresApi()
    val aprobadasApi = AprobadasApi()
    val porcursarApi = PorCursarApi()
    val promeGeneralApi = PromGeneralApi()
    val cursandoApi = CursandoApi()
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
        get("$apiRoot/public/v1/alumnos/Perfil") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""
            val perfil = perfilApi.getPerfil(matricula)
            call.respond(perfil)
        }
        get("$apiRoot/public/v1/alumnos/Boleta") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val boleta = boletaApi.getBoleta(matricula)
            call.respond(boleta)
        }

        get("$apiRoot/public/v1/alumnos/Cursando") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val cursando = cursandoApi.getCursando(matricula)
            call.respond(cursando)
        }
        get("$apiRoot/public/v1/alumnos/Horario") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val horario = callBuscarHorarioSP(matricula)
            call.respond(horario)
        }
        get("$apiRoot/public/v1/alumnos/Aprobadas") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val aprobadas = aprobadasApi.getAprobadas(matricula)
            call.respond(aprobadas)
        }
        get("$apiRoot/public/v1/alumnos/Tutores") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val tutores = tutoresApi.getTutores(matricula)
            call.respond(tutores)
        }
        get("$apiRoot/public/v1/alumnos/PorCursar") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val porcursar = porcursarApi.getPorCursar(matricula)
            call.respond(porcursar)
        }
        get("$apiRoot/public/v1/alumnos/PromedioGeneral") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = queryParameters["matricula"] ?: ""

            val promediogeneral = promeGeneralApi.getPromGeneral(matricula)
            call.respond(promediogeneral)
        }

    }
}

