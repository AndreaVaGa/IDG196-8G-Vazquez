package Clase_02_11

class Product(name: String, barcode: Int, price: Int, qty: Int) {
    private val name = name
    private val barcode = barcode
    private val price = price
    private var qty = qty

    fun getName(): String {
        return name
    }

    fun getBarCode(): Int {
        return barcode
    }

    fun getPrice(): Int {
        return price
    }

    fun getQty(): Int {
        return qty
    }

    fun setQty(cantidad: Int) {
        qty = cantidad
    }
}