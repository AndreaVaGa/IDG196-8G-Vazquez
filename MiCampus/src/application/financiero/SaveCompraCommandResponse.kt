package mx.edu.cetys.garay.andrea.application.financiero

import mx.edu.cetys.garay.andrea.dto.CompraDTO

data class SaveCompraCommandResponse(
    val compra: List<CompraDTO>
)