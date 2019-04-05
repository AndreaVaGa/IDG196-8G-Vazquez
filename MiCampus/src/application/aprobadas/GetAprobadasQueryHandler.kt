package mx.edu.cetys.garay.andrea.application.aprobadas

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetAprobadasQueryHandler : RequestHandler<GetPerfilQuery, List<GetAprobadasQueryResponse>> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetPerfilQuery): List<GetAprobadasQueryResponse> {
        require(message.matricula.isNotBlank())
        val aprobadas = spc.callBuscarAprobadasSP(message.matricula)

        return aprobadas
    }
}