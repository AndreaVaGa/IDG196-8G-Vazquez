package Clase_02_15

data class ShoppingCart(val cliente: Customer, val fecha: String) {
    val products: ArrayList<Product> = arrayListOf()
}