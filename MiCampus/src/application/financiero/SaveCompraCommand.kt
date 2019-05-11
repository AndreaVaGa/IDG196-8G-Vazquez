package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.application.Request


data class SaveCompraCommand(
    val matricula: String,
    val total: Int
) : Request