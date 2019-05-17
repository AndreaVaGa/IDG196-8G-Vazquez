package mx.edu.cetys.garay.andrea.application.tramites


import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.exposed.StoreProcedureCalls

class GetTramitesQueryHandler(private val spc: StoreProcedureCalls) :
    RequestHandler<GetPerfilQuery, GetTramitesQueryResponse> {
    override fun handle(message: GetPerfilQuery): GetTramitesQueryResponse {
        val tramites = spc.callBuscarTramitesSP()
        return tramites
    }
}