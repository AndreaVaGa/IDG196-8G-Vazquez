package mx.edu.cetys.garay.andrea.application.aprobadas

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetAprobadasQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPerfilQuery, GetAprobadasQueryResponse> {

    override fun handle(message: GetPerfilQuery): GetAprobadasQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val aprobadas = spc.callBuscarAprobadasSP(messageA)

        return aprobadas
    }
}