package mx.edu.cetys.garay.andrea.application.perfiles

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls


class GetPerfilQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPerfilQuery, GetPerfilQueryResponse> {

    override fun handle(message: GetPerfilQuery): GetPerfilQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val perfil = spc.callBuscarPerfilSP(messageA)

        return perfil

    }
}