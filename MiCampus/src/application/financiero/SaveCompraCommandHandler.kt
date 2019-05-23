package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class SaveCompraCommandHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<SaveCompraCommand, SaveCompraCommandResponse> {

    override fun handle(message: SaveCompraCommand): SaveCompraCommandResponse {
        require(message.matricula.isNotBlank())
        require(message.tramites.isNotEmpty())
        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val compra = spc.callAddCompraSP(messageA, message.tramites)

        return compra
    }


}