package mx.edu.cetys.garay.andrea.application.horario

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetHorarioQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPerfilQuery, GetHorarioQueryResponse> {
    override fun handle(message: GetPerfilQuery): GetHorarioQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val horario = spc.callBuscarHorarioSP(messageA)

        return horario
    }
}