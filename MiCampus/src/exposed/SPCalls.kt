package mx.edu.cetys.garay.andrea.exposed

import mx.edu.cetys.garay.andrea.*
import mx.edu.cetys.garay.andrea.dto.AprobadasDTO
import mx.edu.cetys.garay.andrea.dto.HorarioDTO
import mx.edu.cetys.garay.andrea.dto.PorCursarDTO
import mx.edu.cetys.garay.andrea.dto.TutoresDTO
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun callBuscarAlumnoSP(user: String, password: String): Map<String, AlumnoDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_alumno '$user','$password'"
    var alumno = hashMapOf<String, AlumnoDTO>()

    Database.connect(
        EXPOSED_CONNECTION_STRING,
        EXPOSED_DRIVER,
        EXPOSED_USER,
        EXPOSED_PASSWORD
    )

    transaction {
        execSp(storedProcedureRawSQL) {
            if (it.next()) {
                alumno["alumno"] = AlumnoDTO(it.getString("Matricula"))
            }
        }
    }
    return alumno
}

fun callBuscarPerfilSP(user: String): Map<String, PerfilDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_perfil '$user'"
    var perfil = hashMapOf<String, PerfilDTO>()

    Database.connect(
        EXPOSED_CONNECTION_STRING,
        EXPOSED_DRIVER,
        EXPOSED_USER,
        EXPOSED_PASSWORD
    )

    transaction {
        execSp(storedProcedureRawSQL) {
            if (it.next()) {
                perfil["perfil"] = PerfilDTO(
                    it.getString("Matricula"),
                    it.getString("Nombre_1"),
                    it.getString("Nombre_2"),
                    it.getString("Apellido_Paterno"),
                    it.getString("Apellido_Materno"),
                    it.getString("Nombre_Programa"),
                    it.getString("Cve_Programa")
                )
            }
        }
    }
    return perfil
}

fun callBuscarBoletaSP(user: String): List<BoletaDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_boleta '$user'"
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
    return boleta
}


fun callBuscarCursandoSP(user: String): List<CursandoDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_cursando '$user'"
    var cursando = ArrayList<CursandoDTO>()

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
    return cursando
}

fun callBuscarHorarioSP(user: String): List<HorarioDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_horario '$user'"
    var horario = ArrayList<HorarioDTO>()

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
                        it.getString("Hora_Inicio"),
                        it.getString("Hora_Final")
                    )
                )
            }
        }
    }
    return horario
}

fun callBuscarAprobadasSP(user: String): List<AprobadasDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_aprobadas'$user'"
    var aprobadas = ArrayList<AprobadasDTO>()

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
    return aprobadas
}

fun callBuscarTutoresSP(user: String): Map<String, TutoresDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_tutores '$user'"
    var tutores = hashMapOf<String, TutoresDTO>()

    Database.connect(
        EXPOSED_CONNECTION_STRING,
        EXPOSED_DRIVER,
        EXPOSED_USER,
        EXPOSED_PASSWORD
    )

    transaction {
        execSp(storedProcedureRawSQL) {
            if (it.next()) {
                tutores["tutores"] = TutoresDTO(
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

fun callBuscarPorCursarSP(user: String): List<PorCursarDTO> {
    val storedProcedureRawSQL = "exec dbo.buscar_porcursar '$user'"
    var porcursar = ArrayList<PorCursarDTO>()

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
                        it.getString("Cve_Materia"),
                        it.getString("Cve_PlanEstudio")
                    )
                )
            }
        }
    }
    return porcursar
}




