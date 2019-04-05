package mx.edu.cetys.garay.andrea.application.boleta

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetBoletaQueryHandler : RequestHandler<GetPerfilQuery, List<GetBoletaQueryResponse>> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetPerfilQuery): List<GetBoletaQueryResponse> {
        require(message.matricula.isNotBlank())
        val boleta = spc.callBuscarBoletaSP(message.matricula)

        return boleta
    }
}