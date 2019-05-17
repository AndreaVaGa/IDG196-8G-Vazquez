package mx.edu.cetys.garay.andrea.application.perfiles

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class SaveFotoCommandHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<SaveFotoCommand, SaveFotoCommandResponse> {

    override fun handle(message: SaveFotoCommand): SaveFotoCommandResponse {
        require(message.matricula.isNotBlank())
        require(message.foto.isNotBlank())
        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val perfil = spc.callCambiarFotoSP(messageA, message.foto)

        return perfil
    }


}