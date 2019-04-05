package mx.edu.cetys.garay.andrea.application.promediogeneral

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetPromGeneralQueryHandler : RequestHandler<GetPromGeneralQuery, GetPromGeneralQueryResponse> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetPromGeneralQuery): GetPromGeneralQueryResponse{
        require(message.matricula.isNotBlank())

        val promediogeneral = spc.callBuscarPromedioGeneralSP(message.matricula)

        return promediogeneral
    }
}