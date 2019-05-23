package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetReciboQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetReciboQuery, GetReciboQueryResponse> {

    override fun handle(message: GetReciboQuery): GetReciboQueryResponse {
        require(message.matricula.isNotBlank())
        require((message.id_compra.toString()).isNotBlank())
        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val recibo = spc.callBuscarReciboSP(messageA, message.id_compra)

        return recibo
    }
}