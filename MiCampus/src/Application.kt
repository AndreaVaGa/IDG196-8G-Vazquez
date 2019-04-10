package mx.edu.cetys.garay.andrea

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryHandler
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryHandler
import mx.edu.cetys.garay.andrea.exposed.*
import mx.edu.cetys.garay.andrea.impl.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "/api/micampus"
    val alumnoApi = AlumnoApi(
        GetMatriculaQueryHandler(SPCallsImpl()),
        GetPerfilQueryHandler(SPCallsImpl()),
        GetBoletaQueryHandler(SPCallsImpl())
    )
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

        get("$apiRoot/public/v1/alumnos/{matricula}/login") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""
            val password = queryParameters["password"] ?: ""

            val response = alumnoApi.getMatricula(matricula, password)

            call.respond(response)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Perfil") {
            val matricula = call.parameters["matricula"] ?: ""
            val perfil = alumnoApi.getPerfil(matricula)
            call.respond(perfil)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Boleta") {
            val matricula = call.parameters["matricula"] ?: ""

            val boleta = alumnoApi.getBoleta(matricula)
            call.respond(boleta)
        }

        get("$apiRoot/public/v1/alumnos/{matricula}/Cursando") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val cursando = cursandoApi.getCursando(matricula)
            call.respond(cursando)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Horario") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val horario = callBuscarHorarioSP(matricula)
            call.respond(horario)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Aprobadas") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val aprobadas = aprobadasApi.getAprobadas(matricula)
            call.respond(aprobadas)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Tutores") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val tutores = tutoresApi.getTutores(matricula)
            call.respond(tutores)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/PorCursar") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val porcursar = porcursarApi.getPorCursar(matricula)
            call.respond(porcursar)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/PromedioGeneral") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val promediogeneral = promeGeneralApi.getPromGeneral(matricula)
            call.respond(promediogeneral)
        }

    }
}

