package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryHandler
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery

class CursandoApi {
    private val getCursandoQueryHandler = GetCursandoQueryHandler()

    fun getCursando(matricula: String): List<GetCursandoResponse> {
        val response = getCursandoQueryHandler.handle(GetPerfilQuery(matricula))
        val nresponse = ArrayList<GetCursandoResponse>()
        for (c in response) {
            nresponse.add(
                GetCursandoResponse(
                    c.cve_periodo,
                    c.nombre_materia,
                    c.nombre_maestro,
                    c.horas_clase
                )
            )

        }
        return nresponse
    }

    data class GetCursandoResponse(
        val cve_periodo : String,
        val nombre_materia:String,
        val nombre_maestro: String,
        val  horas_clase: String)
}