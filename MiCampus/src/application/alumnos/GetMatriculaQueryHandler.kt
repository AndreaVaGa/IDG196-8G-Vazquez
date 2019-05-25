package mx.edu.cetys.garay.andrea.application.alumnos

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetMatriculaQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetMatriculaQuery, GetMatriculaQueryResponse> {

    override fun handle(message: GetMatriculaQuery): GetMatriculaQueryResponse {
        require(message.matricula.isNotBlank())
        require(message.password.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val alumno = spc.callBuscarAlumnoSP(messageA, message.password)

        return GetMatriculaQueryResponse(alumno)
    }
}