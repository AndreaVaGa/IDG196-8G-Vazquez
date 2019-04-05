package mx.edu.cetys.garay.andrea.exposed

import io.ktor.features.NotFoundException
import mx.edu.cetys.garay.andrea.*
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
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



    override fun callBuscarTutoresSP(matricula: String): GetTutoresQueryResponse{
        val storedProcedureRawSQL = "exec dbo.buscar_tutores '$matricula'"
        var tutores: GetTutoresQueryResponse = GetTutoresQueryResponse(
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
                    if (it.next()) {
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
        }

        return tutores
    }

}