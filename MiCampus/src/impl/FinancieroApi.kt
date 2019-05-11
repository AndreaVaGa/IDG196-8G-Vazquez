package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.financiero.*
import mx.edu.cetys.garay.andrea.dto.HistorialDTO

class FinancieroApi(
    private val getHistorialQueryHandler: RequestHandler<GetHistorialQuery, GetHistorialQueryResponse>,
    private val saveCompraCommandHandler: RequestHandler<SaveCompraCommand, SaveCompraCommandResponse>
)
{
    fun getHistorial(matricula: String, id_compra:Int):GetHistorialResponse{
        val response = getHistorialQueryHandler.handle(GetHistorialQuery(matricula, id_compra))
        return GetHistorialResponse(response.historial)
    }
    fun addCompra(request: AddCompraRequest):SaveCompraResponse{
        val response = saveCompraCommandHandler.handle(SaveCompraCommand(request.matricula,request.total))
        return SaveCompraResponse(response)
    }

    data class GetHistorialResponse(val historial: List<HistorialDTO>)
    data class AddCompraRequest(val matricula:String, val total: Int)
    data class SaveCompraResponse(val compra: SaveCompraCommandResponse)
}