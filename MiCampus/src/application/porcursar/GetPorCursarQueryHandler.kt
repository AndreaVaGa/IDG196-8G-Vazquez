package mx.edu.cetys.garay.andrea.application.porcursar

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetPorCursarQueryHandler: RequestHandler<GetPerfilQuery, List<GetPorCursarQueryResponse>> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetPerfilQuery): List<GetPorCursarQueryResponse> {
        require(message.matricula.isNotBlank())
        val porcursar = spc.callBuscarPorCusarSP(message.matricula)

        return porcursar
    }
}