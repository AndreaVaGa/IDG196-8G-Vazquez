package mx.edu.cetys.garay.andrea

data class Alumno(
    val nombre: String,
    val apellido: String,
    val carrera: String,
    val semestre: String,
    val aprobadas: String,
    val matricula: String,
    val tutor1: Tutor
){
    val tutor2 = Tutor("","","","","","", "","","","")
}