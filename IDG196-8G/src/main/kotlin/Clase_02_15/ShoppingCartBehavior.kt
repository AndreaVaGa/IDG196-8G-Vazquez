package Clase_02_15

class ShoppingCartBehavior(val shoppingCart: ShoppingCart) {
    fun removeProduct(product: Product): Boolean {
        if (shoppingCart.products.isEmpty()) {
            return true
        }
        if(shoppingCart.products.contains(product)){
            return shoppingCart.products.remove(product)
        }
        return false
    }
    fun addProduct(product: Product): Boolean {
        if (shoppingCart.products.isEmpty()) {
            return shoppingCart.products.add(product)
        }
        if(shoppingCart.products.contains(product)){
            var posicion = shoppingCart.products.indexOf(product)
            shoppingCart.products[posicion].qty+= product.qty
            print(shoppingCart.products[posicion].qty)
            return true
        }
        return false
    }
}