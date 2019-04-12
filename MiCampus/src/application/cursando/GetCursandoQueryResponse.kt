package mx.edu.cetys.garay.andrea.application.cursando

import mx.edu.cetys.garay.andrea.CursandoDTO

data class GetCursandoQueryResponse(
    val cursando: List<CursandoDTO>
)