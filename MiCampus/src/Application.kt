package mx.edu.cetys.garay.andrea

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import io.ktor.request.receive
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQueryHandler
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryHandler
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryHandler
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryHandler
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryHandler
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryHandler
import mx.edu.cetys.garay.andrea.application.financiero.GetReciboQueryHandler
import mx.edu.cetys.garay.andrea.application.financiero.SaveCompraCommandHandler
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryHandler
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommandHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommandHandler
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryHandler
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryHandler
import mx.edu.cetys.garay.andrea.application.tramites.GetTramitesQueryHandler
import mx.edu.cetys.garay.andrea.exposed.*
import mx.edu.cetys.garay.andrea.impl.FinancieroApi
import mx.edu.cetys.garay.andrea.impl.FinancieroApi.AddCompraRequest


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
        GetPromGeneralQueryHandler(SPCallsImpl()),
        SaveFotoCommandHandler(SPCallsImpl()),
        SaveColorCommandHandler(SPCallsImpl())
    )
    val financieroApi = FinancieroApi(
        GetReciboQueryHandler(SPCallsImpl()),
        SaveCompraCommandHandler(SPCallsImpl()),
        GetHistorialQueryHandler(SPCallsImpl()),
        GetTramitesQueryHandler(SPCallsImpl())
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

        post("$apiRoot/public/v1/alumnos/login") {
            val postObject = call.receive<AlumnoApi.GetMatriculaRequest>()
            call.respond(alumnoApi.getMatricula(postObject))
        }
        route("$apiRoot/public/v1/alumnos/{matricula}/perfil")
        {
            get {
                val matricula = call.parameters["matricula"] ?: ""
                val perfil = alumnoApi.getPerfil(AlumnoApi.GetPerfilRequest(matricula))
                call.respond(perfil)
            }
            put {
                val putObject = call.receive<AlumnoApi.SaveFotoRequest>()
                call.respond(alumnoApi.cambiarFoto(putObject))

            }
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/tutores") {
            val matricula = call.parameters["matricula"] ?: ""

            val tutores = alumnoApi.getTutores(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(tutores)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/boleta") {
            val matricula = call.parameters["matricula"] ?: ""
            val boleta = alumnoApi.getBoleta(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(boleta)
        }
        route("$apiRoot/public/v1/alumnos/{matricula}/horario") {
            get {
                val matricula = call.parameters["matricula"] ?: ""

                val horario = alumnoApi.getHorario(AlumnoApi.GetPerfilRequest(matricula))
                call.respond(horario)
            }
            put{
                val putObject = call.receive<AlumnoApi.SaveColorRequest>()
                call.respond(alumnoApi.cambiarColor(putObject))
            }
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/historial/academico/materias/aprobadas") {
            val matricula = call.parameters["matricula"] ?: ""

            val aprobadas = alumnoApi.getAprobadas(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(aprobadas)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/historial/academico/materias/cursando") {
            val matricula = call.parameters["matricula"] ?: ""
            val cursando = alumnoApi.getCursando(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(cursando)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/historial/academico/materias/porCursar") {
            val matricula = call.parameters["matricula"] ?: ""
            val porcursar = alumnoApi.getPorCursar(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(porcursar)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/historial/academico/promedioGeneral") {
            val matricula = call.parameters["matricula"] ?: ""

            val promediogeneral = alumnoApi.getPromedioGeneral(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(promediogeneral)
        }
        route("$apiRoot/public/v1/alumnos/{matricula}/historial/financiero") {
            get {
                val matricula = call.parameters["matricula"] ?: ""
                val historial = financieroApi.getHistorial(matricula)
                call.respond(historial)
            }
            post {
                val postObject = call.receive<AddCompraRequest>()
                call.respond(financieroApi.addCompra(postObject))
            }
        }
        route("$apiRoot/public/v1/alumnos/{matricula}/historial/financiero/recibo/{id_compra}") {
            get {
                val matricula = call.parameters["matricula"] ?: ""
                val id_compra = call.parameters["id_compra"] ?: "0"

                val recibo = financieroApi.getRecibo(matricula, id_compra.toInt())
                call.respond(recibo)
            }

        }
        get("$apiRoot/public/v1/alumnos/tramites"){
            val matricula = ""
            val tramites = financieroApi.getTramites(matricula)
            call.respond(tramites)
        }


    }
}

