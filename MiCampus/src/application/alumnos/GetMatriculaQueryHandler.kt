package mx.edu.cetys.garay.andrea.application.alumnos

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetMatriculaQueryHandler : RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetMatriculaQuery): GetMatriculaQueryResponse {
        require(message.matricula.isNotBlank())
        require(message.contrasena.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val alumno = spc.callBuscarAlumnoSP(messageA, message.contrasena)

        return GetMatriculaQueryResponse(alumno)
    }
}