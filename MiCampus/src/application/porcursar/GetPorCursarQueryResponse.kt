package mx.edu.cetys.garay.andrea.application.porcursar

import mx.edu.cetys.garay.andrea.dto.PorCursarDTO

data class GetPorCursarQueryResponse(
    val porcursar: List<PorCursarDTO>
)