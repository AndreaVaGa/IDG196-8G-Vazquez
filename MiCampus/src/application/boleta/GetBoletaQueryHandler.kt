package mx.edu.cetys.garay.andrea.application.boleta

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetBoletaQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPerfilQuery, GetBoletaQueryResponse> {

    override fun handle(message: GetPerfilQuery): GetBoletaQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val boleta = spc.callBuscarBoletaSP(messageA)

        return boleta
    }
}