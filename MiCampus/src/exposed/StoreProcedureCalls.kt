package mx.edu.cetys.garay.andrea.exposed

import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse

interface StoreProcedureCalls {
    fun callBuscarAlumnoSP(user: String, password: String): String
    fun callBuscarPerfilSP(matricula: String):  GetPerfilQueryResponse
    fun callBuscarBoletaSP (matricula: String):  GetBoletaQueryResponse
    fun callBuscarTutoresSP (matricula: String): GetTutoresQueryResponse
    fun callBuscarAprobadasSP (matricula: String):  List<GetAprobadasQueryResponse>
    fun callBuscarPorCusarSP (matricula: String):  List<GetPorCursarQueryResponse>
    fun callBuscarPromedioGeneralSP(matricula: String):  GetPromGeneralQueryResponse
    fun callBuscarCursandoSP (matricula: String):  List<GetCursandoQueryResponse>
}