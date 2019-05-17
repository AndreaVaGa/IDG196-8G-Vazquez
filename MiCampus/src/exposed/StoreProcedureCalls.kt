package mx.edu.cetys.garay.andrea.exposed

import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQueryResponse
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryResponse
import mx.edu.cetys.garay.andrea.application.aprobadas.GetAprobadasQueryResponse
import mx.edu.cetys.garay.andrea.application.boleta.GetBoletaQueryResponse
import mx.edu.cetys.garay.andrea.application.cursando.GetCursandoQueryResponse
import mx.edu.cetys.garay.andrea.application.financiero.GetReciboQueryResponse
import mx.edu.cetys.garay.andrea.application.financiero.SaveCompraCommandResponse
import mx.edu.cetys.garay.andrea.application.horario.GetHorarioQueryResponse
import mx.edu.cetys.garay.andrea.application.horario.SaveColorCommandResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQueryResponse
import mx.edu.cetys.garay.andrea.application.perfiles.SaveFotoCommandResponse
import mx.edu.cetys.garay.andrea.application.porcursar.GetPorCursarQueryResponse
import mx.edu.cetys.garay.andrea.application.promediogeneral.GetPromGeneralQueryResponse
import mx.edu.cetys.garay.andrea.application.tramites.GetTramitesQueryResponse
import mx.edu.cetys.garay.andrea.dto.TramitesDTO

interface StoreProcedureCalls {
    fun callBuscarAlumnoSP(user: String, password: String): String
    fun callBuscarPerfilSP(matricula: String): GetPerfilQueryResponse
    fun callBuscarBoletaSP(matricula: String): GetBoletaQueryResponse
    fun callBuscarTutoresSP(matricula: String): GetTutoresQueryResponse
    fun callBuscarHorarioSP(matricula: String): GetHorarioQueryResponse
    fun callBuscarAprobadasSP(matricula: String): GetAprobadasQueryResponse
    fun callBuscarPorCusarSP(matricula: String): GetPorCursarQueryResponse
    fun callBuscarPromedioGeneralSP(matricula: String): GetPromGeneralQueryResponse
    fun callBuscarCursandoSP(matricula: String): GetCursandoQueryResponse
    fun callBuscarHistorialSP(matricula: String, id_compra:Int): GetReciboQueryResponse
    fun callBuscarReciboSP(matricula: String): GetHistorialQueryResponse
    fun callAddCompraSP(matricula: String, total: Int, tramites: List<TramitesDTO>): SaveCompraCommandResponse
    fun callCambiarFotoSP(matricula: String, foto: String): SaveFotoCommandResponse
    fun callCambiarColorSP(matricula: String, materia: String, color: String): SaveColorCommandResponse
    fun callBuscarTramitesSP(): GetTramitesQueryResponse
}