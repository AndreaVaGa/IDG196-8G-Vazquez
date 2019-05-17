package mx.edu.cetys.garay.andrea.application.horario

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class SaveColorCommandHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<SaveColorCommand, SaveColorCommandResponse> {
    override fun handle(message: SaveColorCommand): SaveColorCommandResponse {
        require(message.matricula.isNotBlank())
        require(message.materia.isNotBlank())
        require(message.color.isNotBlank())


        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val horario = spc.callCambiarColorSP(messageA, message.materia, message.color)

        return horario
    }
}