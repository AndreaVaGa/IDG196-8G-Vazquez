package mx.edu.cetys.garay.andrea.application.Tutores

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.exposed.SPCallsImpl
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetTutoresQueryHandler: RequestHandler<GetTutoresQuery, GetTutoresQueryResponse> {
    private val spc: StoreProcedureCalls = SPCallsImpl()

    override fun handle(message: GetTutoresQuery): GetTutoresQueryResponse {
        require(message.matricula.isNotBlank())
        val tutores = spc.callBuscarTutoresSP(message.matricula)

        return tutores
    }
}