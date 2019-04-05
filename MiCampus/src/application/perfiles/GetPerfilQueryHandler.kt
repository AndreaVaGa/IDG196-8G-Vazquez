package mx.edu.cetys.garay.andrea.application.perfiles

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls


class GetPerfilQueryHandler : RequestHandler<GetPerfilQuery, GetPerfilQueryResponse> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetPerfilQuery): GetPerfilQueryResponse {
        require(message.matricula.isNotBlank())

        var messageA = message.matricula.toUpperCase()
        when (messageA[0]) {
            'T', 'M', 'E' -> messageA = messageA.substring(1)
        }

        val perfil = spc.callBuscarPerfilSP(messageA)

        return perfil
        /*return GetPerfilQueryResponse(
            perfil.matricula,
            perfil.nombre_1,
            perfil.nombre_2,
            perfil.apellido_paterno,
            perfil.apellido_materno,
            perfil.nombre_programa,
            perfil.cve_programa,
            perfil.materias_aprobadas
            )*/
    }
}