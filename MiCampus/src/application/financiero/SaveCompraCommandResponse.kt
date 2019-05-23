package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.dto.ReciboDTO

data class SaveCompraCommandResponse(
    val compra: List<ReciboDTO>
)