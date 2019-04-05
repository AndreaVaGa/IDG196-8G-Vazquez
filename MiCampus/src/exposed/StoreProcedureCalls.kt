package mx.edu.cetys.garay.andrea.exposed

import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse

interface StoreProcedureCalls {
    fun callBuscarAlumnoSP(user: String, password: String): String
    fun callBuscarPerfilSP(matricula: String):  GetPerfilQueryResponse
    fun callBuscarBoletaSP (matricula: String):  List<GetBoletaQueryResponse>
    fun callBuscarTutoresSP (matricula: String): GetTutoresQueryResponse
}