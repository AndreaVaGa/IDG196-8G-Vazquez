package mx.edu.cetys.garay.andrea.exposed

import io.ktor.features.NotFoundException
import mx.edu.cetys.garay.andrea.*
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

    override fun callBuscarPerfilSP(user: String): GetPerfilQueryResponse {
        val storedProcedureRawSQL = "exec dbo.buscar_perfil '$user'"
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


}