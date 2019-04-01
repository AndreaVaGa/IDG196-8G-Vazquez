package mx.edu.cetys.garay.andrea.application.alumnos

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetMatriculaQueryHandler : RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetMatriculaQuery): GetMatriculaQueryResponse {
        require(message.matricula.isNotBlank())
        require(message.contrasena.isNotBlank())

        val alumno = spc.callBuscarAlumnoSP(message.matricula, message.contrasena)

        return GetMatriculaQueryResponse(alumno)
    }
}