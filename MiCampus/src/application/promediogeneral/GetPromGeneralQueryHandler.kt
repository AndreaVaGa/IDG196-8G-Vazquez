package mx.edu.cetys.garay.andrea.application.promediogeneral

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetPromGeneralQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPromGeneralQuery, GetPromGeneralQueryResponse> {

    override fun handle(message: GetPromGeneralQuery): GetPromGeneralQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val promediogeneral = spc.callBuscarPromedioGeneralSP(messageA)

        return promediogeneral
    }
}