package mx.edu.cetys.garay.andrea.application.cursando

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetCursandoQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPerfilQuery, GetCursandoQueryResponse> {

    override fun handle(message: GetPerfilQuery): GetCursandoQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val cursando = spc.callBuscarCursandoSP(messageA)

        return cursando
    }
}