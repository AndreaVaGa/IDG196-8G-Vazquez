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
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetReciboQueryHandler
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryHandler
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQuery
import mx.edu.cetys.garay.andrea.application.alumnos.GetMatriculaQueryHandler
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryHandler
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryHandler
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryHandler
import mx.edu.cetys.garay.andrea.application.financiero.GetHistorialQueryHandler
import mx.edu.cetys.garay.andrea.application.financiero.SaveCompraCommandHandler
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommand
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommandHandler
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryHandler
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryHandler
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
        SaveFotoCommandHandler(SPCallsImpl())
    )
    val financieroApi = FinancieroApi(
        GetHistorialQueryHandler(SPCallsImpl()),
        SaveCompraCommandHandler(SPCallsImpl()),
        GetReciboQueryHandler(SPCallsImpl())
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
        route("$apiRoot/public/v1/alumnos/{matricula}/Perfil")
        {
            get {
                val matricula = call.parameters["matricula"] ?: ""
                val perfil = alumnoApi.getPerfil(AlumnoApi.GetPerfilRequest(matricula))
                call.respond(perfil)
            }
            put {
                val putObject = call.receive<AlumnoApi.SaveFotoRequest>()
                call.respond(alumnoApi.changeFoto(putObject))

            }
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Tutores") {
            val matricula = call.parameters["matricula"] ?: ""

            val tutores = alumnoApi.getTutores(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(tutores)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Boleta") {
            val matricula = call.parameters["matricula"] ?: ""
            val boleta = alumnoApi.getBoleta(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(boleta)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Horario") {
            val matricula = call.parameters["matricula"] ?: ""

            val horario = alumnoApi.getHorario(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(horario)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Historial/Academico/Materias/Aprobadas") {
            val matricula = call.parameters["matricula"] ?: ""

            val aprobadas = alumnoApi.getAprobadas(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(aprobadas)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Historial/Academico/Materias/Cursando") {
            val matricula = call.parameters["matricula"] ?: ""
            val cursando = alumnoApi.getCursando(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(cursando)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Historial/Academico/Materias/PorCursar") {
            val matricula = call.parameters["matricula"] ?: ""
            val porcursar = alumnoApi.getPorCursar(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(porcursar)
        }
        get("$apiRoot/public/v1/alumnos/{matricula}/Historial/Academico/PromedioGeneral") {
            val matricula = call.parameters["matricula"] ?: ""

            val promediogeneral = alumnoApi.getPromedioGeneral(AlumnoApi.GetPerfilRequest(matricula))
            call.respond(promediogeneral)
        }
        route("$apiRoot/public/v1/alumnos/{matricula}/Historial/Financiero") {
            get {
                val matricula = call.parameters["matricula"] ?: ""
                val recibo = financieroApi.getRecibo(matricula)
                call.respond(recibo)
            }
            post {
                val postObject = call.receive<AddCompraRequest>()

                call.respond(financieroApi.addCompra(postObject))
            }
        }
        route("$apiRoot/public/v1/alumnos/{matricula}/Historial/Financiero/Recibo/{id_compra}") {
            get {
                val matricula = call.parameters["matricula"] ?: ""
                val id_compra = call.parameters["id_compra"] ?: "0"

                val historial = financieroApi.getHistorial(matricula, id_compra.toInt())
                call.respond(historial)
            }

        }


    }
}

