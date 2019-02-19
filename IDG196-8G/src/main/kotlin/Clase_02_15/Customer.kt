package Clase_02_15

data class Customer(
    val name: String,
    val email: String
) {
    val payments: ArrayList<Payment> = arrayListOf()
    var address: String = ""
}