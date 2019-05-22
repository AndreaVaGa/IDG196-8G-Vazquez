package mx.edu.cetys.garay.andrea.application.perfiles

data class SaveFotoCommandResponse(
    val matricula: String,
    val nombre_1: String,
    val nombre_2: String,
    val apellido_paterno: String,
    val apellido_materno: String,
    val foto_portada: String
)