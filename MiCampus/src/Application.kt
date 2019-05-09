package mx.edu.cetys.garay.andrea

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryHandler
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryHandler
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryHandler
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryHandler
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryHandler
import mx.edu.cetys.garay.andrea.application.financiero.GetHistorialQueryHandler
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryHandler
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryHandler
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryHandler
import mx.edu.cetys.garay.andrea.exposed.*
import mx.edu.cetys.garay.andrea.impl.FinancieroApi


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "/api/micampus"
    val alumnoApi = AlumnoApi(
        GetMatriculaQueryHandler(SPCallsImpl()),
        GetPerfilQueryHandler(SPCallsImpl()),
        GetBoletaQueryHandler(SPCallsImpl()),
        GetHorarioQueryHandler(SPCallsImpl()),
        GetAprobadasQueryHandler(SPCallsImpl()),
        GetPorCursarQueryHandler(SPCallsImpl()),
        GetCursandoQueryHandler(SPCallsImpl()),
        GetTutoresQueryHandler(SPCallsImpl()),
        GetPromGeneralQueryHandler(SPCallsImpl())
    )
    val financieroApi = FinancieroApi(
        GetHistorialQueryHandler(SPCallsImpl())
    )
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

            val cursando = alumnoApi.getCursando(matricula)
            call.respond(cursando)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Horario") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val horario = alumnoApi.getHorario(matricula)
            call.respond(horario)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Aprobadas") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val aprobadas = alumnoApi.getAprobadas(matricula)
            call.respond(aprobadas)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Tutores") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val tutores = alumnoApi.getTutores(matricula)
            call.respond(tutores)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/PorCursar") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val porcursar = alumnoApi.getPorCursar(matricula)
            call.respond(porcursar)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/PromedioGeneral") {
            val request = this.context.request
            val queryParameters: Parameters = request.queryParameters
            val matricula = call.parameters["matricula"] ?: ""

            val promediogeneral = alumnoApi.getPromedioGeneral(matricula)
            call.respond(promediogeneral)
        }

        get("$apiRoot/public/v1/financiero/Historial/Financiero/{matricula}/{id_compra}") {
            val request = this.context.request

            val matricula = call.parameters["matricula"] ?: ""
            val id_compra = call.parameters["id_compra"] ?: "0"
            id_compra.toInt()

            val historial = financieroApi.getHistorial(matricula,id_compra.toInt())
            call.respond(historial)
        }

    }
}

