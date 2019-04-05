package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryHandler
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery

class BoletaApi {
    private val getBoletaQueryHandler = GetBoletaQueryHandler()

    fun getBoleta(matricula: String): List<GetBoletaResponse> {
        val response = getBoletaQueryHandler.handle(GetPerfilQuery(matricula))
        val nresponse = ArrayList<GetBoletaResponse>()
        for (c in response) {
            nresponse.add(
                GetBoletaResponse(
                    c.cve_periodo,
                    c.nombre_materia,
                    c.nombre_maestro,
                    c.promedio,
                    c.faltas_totales,
                    c.calificacion1,
                    c.calificacion2,
                    c.calificacion3,
                    c.faltas1,
                    c.faltas2,
                    c.faltas3,
                    c.faltas_tardias
                )
            )

        }
        return nresponse
    }

    data class GetBoletaResponse(
        val cve_periodo: String,
        val nombre_materia: String,
        val nombre_maestro: String,
        val promedio: String,
        val faltas_totales: String,
        val calificacion1: String,
        val calificacion2: String,
        val calificacion3: String,
        val faltas1: String,
        val faltas2: String,
        val faltas3: String,
        val faltas_tardias: String
    )
}