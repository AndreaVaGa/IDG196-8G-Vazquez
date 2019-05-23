package mx.edu.cetys.garay.andrea.application.HistorialFin

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetHistorialQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetHistorialQuery, GetHistorialQueryResponse> {

    override fun handle(message: GetHistorialQuery): GetHistorialQueryResponse {
        require(message.matricula.isNotBlank())
        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val historial = spc.callBuscarHistorialSP(messageA)

        return historial
    }
}