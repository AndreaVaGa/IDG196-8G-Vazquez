package mx.edu.cetys.garay.andrea.exposed

import io.ktor.features.NotFoundException
import mx.edu.cetys.garay.andrea.*
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQueryResponse
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryResponse
import mx.edu.cetys.garay.andrea.application.financiero.GetReciboQueryResponse
import mx.edu.cetys.garay.andrea.application.financiero.SaveCompraCommandResponse
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryResponse
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommandResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommandResponse
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import mx.edu.cetys.garay.andrea.application.tramites.GetTramitesQueryResponse
import mx.edu.cetys.garay.andrea.application.tramites.SaveTramitesCommandResponse
import mx.edu.cetys.garay.andrea.dto.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

class SPCallsImpl : StoreProcedureCalls {
    override fun callBuscarAlumnoSP(user: String, password: String): String {
        val storedProcedureRawSQL = "exec dbo.buscar_alumno '$user','$password'"
        var matricula = ""
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                if (it.next()) {
                    val statusCode = it.getInt("StatusCode")
                    when (statusCode) {
                        500 -> throw Exception("FAIL")
                        404 -> throw NotFoundException()
                    }
                    matricula = it.getString("Matricula")
                }
            }
        }
        return matricula
    }

    override fun callBuscarPerfilSP(matricula: String): GetPerfilQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_perfil '$matricula'"
        var perfil = GetPerfilQueryResponse(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                if (it.next()) {
                    val statusCode = it.getInt("StatusCode")
                    when (statusCode) {
                        500 -> throw Exception("FAIL")
                        404 -> throw NotFoundException()
                    }

                    perfil = GetPerfilQueryResponse(
                        it.getString("Matricula"),
                        it.getString("Nombre_1"),
                        it.getString("Nombre_2"),
                        it.getString("Apellido_Paterno"),
                        it.getString("Apellido_Materno"),
                        it.getString("Nombre_Programa"),
                        it.getString("Cve_Programa"),
                        it.getString("materias_aprobadas"),
                        it.getString("foto_portada")
                    )

                }
            }
        }

        return perfil
    }

    override fun callBuscarBoletaSP(matricula: String): GetBoletaQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_boleta '$matricula'"

        val boleta = ArrayList<BoletaDTO>()
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    boleta.add(
                        BoletaDTO(
                            it.getString("Cve_Periodo"),
                            it.getString("Nombre_Materia"),
                            it.getString("Nombre_Maestro"),
                            it.getString("Promedio"),
                            it.getString("FaltasTotales"),
                            it.getString("Calificacion1"),
                            it.getString("Calificacion2"),
                            it.getString("Calificacion3"),
                            it.getString("Faltas1"),
                            it.getString("Faltas2"),
                            it.getString("Faltas3"),
                            it.getString("Faltas_Tardias")

                        )
                    )
                }
            }
        }

        return GetBoletaQueryResponse(boleta)
    }


    override fun callBuscarTutoresSP(matricula: String): GetTutoresQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_tutores '$matricula'"
        var tutores = GetTutoresQueryResponse(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                if (it.next()) {
                    val statusCode = it.getInt("StatusCode")
                    when (statusCode) {
                        500 -> throw Exception("FAIL")
                        404 -> throw NotFoundException()
                    }
                    tutores = GetTutoresQueryResponse(
                        it.getString("Nombre_1_Padre"),
                        it.getString("Nombre_2_Padre"),
                        it.getString("Apellido_Paterno_Padre"),
                        it.getString("Apellido_Materno_Padre"),
                        it.getString("Direccion_Padre"),
                        it.getString("Colonia_Padre"),
                        it.getString("Telefono_Padre"),
                        it.getString("Email_Padre"),
                        it.getString("Telefono_Celular_Pad"),
                        it.getString("Empresa_Padre"),
                        it.getString("Emp_Dir_Padre"),
                        it.getString("Emp_Col_Padre"),
                        it.getString("Emp_Tel_Padre"),
                        it.getString("Nombre_1_Madre"),
                        it.getString("Nombre_2_Madre"),
                        it.getString("Apellido_Paterno_Madre"),
                        it.getString("Apellido_Materno_Madre"),
                        it.getString("Direccion_Madre"),
                        it.getString("Colonia_Madre"),
                        it.getString("Telefono_Madre"),
                        it.getString("Email_Madre"),
                        it.getString("Telefono_Celular_Madre"),
                        it.getString("Empresa_Madre"),
                        it.getString("Emp_Dir_Madre"),
                        it.getString("Emp_Col_Madre"),
                        it.getString("Emp_Tel_Madre")
                    )

                }
            }
        }

        return tutores
    }


    override fun callBuscarHorarioSP(matricula: String): GetHorarioQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_horario '$matricula'"

        val horario = ArrayList<HorarioDTO>()
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    horario.add(
                        HorarioDTO(
                            it.getString("Nombre_Materia"),
                            it.getString("Nombre_Maestro"),
                            it.getString("Cve_Periodo"),
                            it.getString("Dia"),
                            it.getString("Lugar"),
                            it.getString("Hora_Inicio"),
                            it.getString("Hora_Final"),
                            it.getString("Color")
                        )
                    )
                }
            }
        }

        return GetHorarioQueryResponse(horario)
    }

    override fun callBuscarAprobadasSP(matricula: String): GetAprobadasQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_aprobadas '$matricula'"
        val aprobadas = ArrayList<AprobadasDTO>()

        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    aprobadas.add(
                        AprobadasDTO(
                            it.getString("Cve_Periodo"),
                            it.getString("Nombre_Materia"),
                            it.getString("Nombre_Maestro"),
                            it.getString("Horas_Clase"),
                            it.getString("Calificacion_Final")

                        )
                    )
                }
            }
        }
        return GetAprobadasQueryResponse(aprobadas)
    }

    override fun callBuscarPorCusarSP(matricula: String): GetPorCursarQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_porcursar '$matricula'"
        val porcursar = ArrayList<PorCursarDTO>()

        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    porcursar.add(
                        PorCursarDTO(
                            it.getString("Nombre_Materia"),
                            it.getString("Horas_Clase"),
                            it.getString("Cve_Materia"),
                            it.getString("Cve_PlanEstudio")
                        )
                    )
                }
            }
        }
        return GetPorCursarQueryResponse(porcursar)
    }


    override fun callBuscarPromedioGeneralSP(matricula: String): GetPromGeneralQueryResponse {
        val storedProcedureRawSQL = "exec dbo.Promedio_General '$matricula'"
        var promediogeneral = GetPromGeneralQueryResponse(
            ""
        )
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                if (it.next()) {
                    val statusCode = it.getInt("StatusCode")
                    when (statusCode) {
                        500 -> throw Exception("FAIL")
                        404 -> throw NotFoundException()
                    }

                    promediogeneral = GetPromGeneralQueryResponse(
                        it.getString("PromedioGeneral")
                    )

                }
            }
        }

        return promediogeneral
    }

    override fun callBuscarCursandoSP(matricula: String): GetCursandoQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_cursando '$matricula'"
        val cursando = ArrayList<CursandoDTO>()

        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    cursando.add(
                        CursandoDTO(
                            it.getString("Cve_Periodo"),
                            it.getString("Nombre_Materia"),
                            it.getString("Nombre_Maestro"),
                            it.getString("Horas_Clase")

                        )
                    )
                }
            }
        }
        return GetCursandoQueryResponse(cursando)
    }


    override fun callBuscarReciboSP(matricula: String, id_compra: Int): GetReciboQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_recibo '$matricula','$id_compra'"

        val historial = ArrayList<HistorialDTO>()
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    historial.add(
                        HistorialDTO(
                            it.getInt("id_compra"),
                            it.getString("date"),
                            it.getInt("id_tramites"),
                            it.getString("name"),
                            it.getInt("price")
                        )
                    )
                }
            }
        }

        return GetReciboQueryResponse(historial)
    }

    override fun callAddCompraSP(
        matricula: String,
        tramites: String
    ): SaveCompraCommandResponse {
        val storedProcedureRawSQL = "exec dbo.add_compra '$matricula','$tramites'"
        var compra = ArrayList<ReciboDTO>()

        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                if (it.next()) {
                    val statusCode = it.getInt("StatusCode")
                    when (statusCode) {
                        500 -> throw Exception("FAIL")
                    }
                    compra.add(
                        ReciboDTO(
                            it.getInt("id_compra"),
                            it.getString("matricula"),
                            it.getString("date"),
                            it.getInt("id_tramites"),
                            it.getString("name"),
                            it.getInt("precio"),
                            it.getInt("monto_total")
                        )
                    )
                }
            }


        }

        return SaveCompraCommandResponse(compra)
    }

    override fun callCambiarFotoSP(matricula: String, foto: String): SaveFotoCommandResponse {
        val storedProcedureRawSQL = "exec dbo.cambiar_foto '$matricula','$foto'"
        var perfil = SaveFotoCommandResponse("", "", "", "", "", "", "", "", "")

        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                if (it.next()) {
                    val statusCode = it.getInt("StatusCode")
                    when (statusCode) {
                        500 -> throw Exception("FAIL")
                    }
                    perfil = SaveFotoCommandResponse(
                        it.getString("Matricula"),
                        it.getString("Nombre_1"),
                        it.getString("Nombre_2"),
                        it.getString("Apellido_Paterno"),
                        it.getString("Apellido_Materno"),
                        it.getString("Nombre_Programa"),
                        it.getString("Cve_Programa"),
                        it.getString("materias_aprobadas"),
                        it.getString("foto_portada")

                    )
                }
            }
        }
        return perfil
    }

    override fun callCambiarColorSP(matricula: String, materia: String, color: String): SaveColorCommandResponse {
        val storedProcedureRawSQL = "exec dbo.cambiar_color '$matricula','$materia','$color'"
        val horario = ArrayList<HorarioDTO>()
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    horario.add(
                        HorarioDTO(
                            it.getString("Nombre_Materia"),
                            it.getString("Nombre_Maestro"),
                            it.getString("Cve_Periodo"),
                            it.getString("Dia"),
                            it.getString("Lugar"),
                            it.getString("Hora_Inicio"),
                            it.getString("Hora_Final"),
                            it.getString("Color")
                        )
                    )
                }
            }
        }

        return SaveColorCommandResponse(horario)
    }


    override fun callBuscarHistorialSP(matricula: String): GetHistorialQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_historial_financiero '$matricula'"

        val recibo = ArrayList<HistorialDTO>()
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    recibo.add(
                        HistorialDTO(
                            it.getInt("id_compra"),
                            it.getString("date"),
                            it.getInt("id_tramites"),
                            it.getString("name"),
                            it.getInt("price")
                        )
                    )
                }
            }
        }

        return GetHistorialQueryResponse(recibo)
    }

    override fun callBuscarTramitesSP(): GetTramitesQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_tramites "

        val tramites = ArrayList<TramitesDTO>()
        Database.connect(
            EXPOSED_CONNECTION_STRING,
            EXPOSED_DRIVER,
            EXPOSED_USER,
            EXPOSED_PASSWORD
        )

        transaction {
            execSp(storedProcedureRawSQL) {
                while (it.next()) {
                    tramites.add(
                        TramitesDTO(
                            it.getInt("id"),
                            it.getString("name"),
                            it.getInt("price")
                        )
                    )
                }
            }
        }

        return GetTramitesQueryResponse(tramites)
    }


}




