package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQuery
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQueryResponse
import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.financiero.*
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.tramites.GetTramitesQueryResponse
import mx.edu.cetys.garay.andrea.dto.HistorialDTO
import mx.edu.cetys.garay.andrea.dto.ReciboDTO
import mx.edu.cetys.garay.andrea.dto.TramitesDTO

class FinancieroApi(
    private val getReciboQueryHandler: RequestHandler<GetReciboQuery, GetReciboQueryResponse>,
    private val saveCompraCommandHandler: RequestHandler<SaveCompraCommand, SaveCompraCommandResponse>,
    private val getHistorialQueryHandler: RequestHandler<GetHistorialQuery, GetHistorialQueryResponse>,
    private val getTramitesQueryHandler: RequestHandler<GetPerfilQuery,GetTramitesQueryResponse>
)
{
    fun getRecibo(matricula: String, id_compra:Int):GetReciboResponse{
        val response = getReciboQueryHandler.handle(GetReciboQuery(matricula, id_compra))
        return GetReciboResponse(response.recibo)
    }

    fun getHistorial(matricula: String):GetHistorialResponse{
        val response = getHistorialQueryHandler.handle(GetHistorialQuery(matricula))
        return GetHistorialResponse(response.historial)
    }

    fun addCompra(request: AddCompraRequest):SaveCompraResponse{
        val response = saveCompraCommandHandler.handle(SaveCompraCommand(request.matricula, request.tramites))
        return SaveCompraResponse(response.compra)
    }
    fun getTramites(matricula: String):GetTramitesResponse{
        val response = getTramitesQueryHandler.handle(GetPerfilQuery(matricula))
        return  GetTramitesResponse(response.tramites)
    }

    data class GetHistorialResponse(val historial: List<HistorialDTO>)
    data class AddCompraRequest(val matricula:String,  val tramites: String)
    data class SaveCompraResponse(val compra:List<ReciboDTO>)
    data class GetReciboResponse(val recibo: List<HistorialDTO>)
    data class GetTramitesResponse(val tramites: List<TramitesDTO>)

}