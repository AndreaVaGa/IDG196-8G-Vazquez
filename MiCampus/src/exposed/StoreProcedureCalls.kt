package mx.edu.cetys.garay.andrea.exposed

interface StoreProcedureCalls {
    fun callBuscarAlumnoSP(user: String, password: String): String
}