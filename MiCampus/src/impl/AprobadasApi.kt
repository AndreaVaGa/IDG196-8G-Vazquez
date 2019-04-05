package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery

class AprobadasApi {
    private val getAprobadasQueryHandler = GetAprobadasQueryHandler()

    fun getAprobadas(matricula: String): List<GetAprobadasResponse> {
        val response = getAprobadasQueryHandler.handle(GetPerfilQuery(matricula))
        val nresponse = ArrayList<GetAprobadasResponse>()
        for (c in response) {
            nresponse.add(
                GetAprobadasResponse(
                    c.cve_periodo,
                    c.nombre_materia,
                    c.nombre_maestro,
                    c.horas_clase,
                    c.calificacion_final
                )
            )

        }
        return nresponse
    }

    data class GetAprobadasResponse(
        val cve_periodo: String,
        val nombre_materia: String,
        val nombre_maestro: String,
        val horas_clase: String,
        val calificacion_final: String
    )
}