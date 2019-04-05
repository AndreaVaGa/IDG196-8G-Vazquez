package mx.edu.cetys.garay.andrea.application.cursando

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetCursandoQueryHandler: RequestHandler<GetPerfilQuery, List<GetCursandoQueryResponse>> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetPerfilQuery): List<GetCursandoQueryResponse> {
        require(message.matricula.isNotBlank())
        val cursando = spc.callBuscarCursandoSP(message.matricula)

        return cursando
    }
}