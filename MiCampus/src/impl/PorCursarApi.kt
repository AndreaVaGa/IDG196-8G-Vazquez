package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryHandler

class PorCursarApi {
    private val getPorCursarQueryHandler = GetPorCursarQueryHandler()

    fun getPorCursar(matricula: String): List<GetPorCursarResponse> {
        val response = getPorCursarQueryHandler.handle(GetPerfilQuery(matricula))
        val nresponse = ArrayList<GetPorCursarResponse>()
        for (c in response) {
            nresponse.add(
                GetPorCursarResponse(
                    c.nombre_materia,
                    c.horas_clase,
                    c.cve_materia,
                    c.cve_planestudio
                )
            )

        }
        return nresponse
    }

    data class GetPorCursarResponse(
        val nombre_materia: String,
        val horas_clase: String,
        val cve_materia:String,
        val cve_planestudio: String
    )
}
