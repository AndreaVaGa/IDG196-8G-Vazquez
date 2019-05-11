package mx.edu.cetys.garay.andrea.application.financiero

data class SaveCompraCommandResponse(
    val id_compra: Int,
    val matricula: String,
    val date: String,
    val total : Int

)