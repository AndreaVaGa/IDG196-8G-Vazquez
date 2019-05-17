package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.application.Request
import mx.edu.cetys.garay.andrea.dto.TramitesDTO


data class SaveCompraCommand(
    val matricula: String,
    val total: Int,
    val tramites: List<TramitesDTO>
) : Request