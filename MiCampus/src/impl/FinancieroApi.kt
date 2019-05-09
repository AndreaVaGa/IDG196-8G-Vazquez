package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.financiero.GetHistorialQuery
import mx.edu.cetys.garay.andrea.application.financiero.GetHistorialQueryResponse
import mx.edu.cetys.garay.andrea.dto.HistorialDTO

class FinancieroApi(
    private val getHistorialQueryHandler: RequestHandler<GetHistorialQuery, GetHistorialQueryResponse>
)
{
    fun getHistorial(matricula: String, id_compra:Int):GetHistorialResponse{
        val response = getHistorialQueryHandler.handle(GetHistorialQuery(matricula, id_compra))
        return GetHistorialResponse(response.historial)
    }

    data class GetHistorialResponse(val historial: List<HistorialDTO>)
}