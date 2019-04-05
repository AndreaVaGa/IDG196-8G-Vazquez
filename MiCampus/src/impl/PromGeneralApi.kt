package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQuery
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryHandler

class PromGeneralApi {
    private val getPromGeneralQueryHandler =GetPromGeneralQueryHandler()

    fun getPromGeneral(matricula: String): GetPromGeneralResponse {
        val response = getPromGeneralQueryHandler.handle(GetPromGeneralQuery(matricula))
        return GetPromGeneralResponse(
            response.promedio_general
        )
    }

    data class GetPromGeneralResponse(
        val promedio_general: String
    )
}