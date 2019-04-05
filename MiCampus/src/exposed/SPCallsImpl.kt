package mx.edu.cetys.garay.andrea.exposed

import io.ktor.features.NotFoundException
import mx.edu.cetys.garay.andrea.*
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
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
        var perfil: GetPerfilQueryResponse = GetPerfilQueryResponse(
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
                    if (it.next()) {
                        perfil = GetPerfilQueryResponse(
                            it.getString("Matricula"),
                            it.getString("Nombre_1"),
                            it.getString("Nombre_2"),
                            it.getString("Apellido_Paterno"),
                            it.getString("Apellido_Materno"),
                            it.getString("Nombre_Programa"),
                            it.getString("Cve_Programa"),
                            it.getString("materias_aprobadas")
                        )
                    }
                }
            }
        }

        return perfil
    }

    override fun callBuscarBoletaSP(matricula: String): List<GetBoletaQueryResponse> {
        val storedProcedureRawSQL = "exec dbo.buscar_boleta '$matricula'"
        val boleta = ArrayList<GetBoletaQueryResponse>()

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
                        GetBoletaQueryResponse(
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
        return boleta
    }


}