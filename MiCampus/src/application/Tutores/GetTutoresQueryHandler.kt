package mx.edu.cetys.garay.andrea.application.Tutores

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetTutoresQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetTutoresQuery, GetTutoresQueryResponse> {

    override fun handle(message: GetTutoresQuery): GetTutoresQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val tutores = spc.callBuscarTutoresSP(messageA)

        return tutores
    }
}