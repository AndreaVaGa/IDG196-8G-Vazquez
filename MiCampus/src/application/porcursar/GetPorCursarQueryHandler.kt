package mx.edu.cetys.garay.andrea.application.porcursar

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetPorCursarQueryHandler(private val spc: StoreProcedureCalls) : RequestHandler<GetPerfilQuery, GetPorCursarQueryResponse> {

    override fun handle(message: GetPerfilQuery): GetPorCursarQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val porcursar = spc.callBuscarPorCusarSP(messageA)

        return porcursar
    }
}