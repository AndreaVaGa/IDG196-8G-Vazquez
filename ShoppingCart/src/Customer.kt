package mx.edu.cetys.garay.andrea

data class Customer(
    val name: String,
    val email: String
) {
    var payments: ArrayList<Payment> = arrayListOf()
    var address: String = ""
    var cart: ShoppingCart= ShoppingCart()
}