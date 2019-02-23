package Clase_02_15

class ShoppingCartBehavior(val shoppingCart: ShoppingCart) {
    fun removeProduct(product: Product, qty: Int): Boolean {
        if (shoppingCart.products.isEmpty()) {
            return true
        }
        if (shoppingCart.products.contains(product)) {
            var temporal = shoppingCart.products[product]

            if (qty < temporal!!) {
                var new = temporal!! - qty
                shoppingCart.products[product] = new
                println(shoppingCart.products[product])
                return true
            } else {
                shoppingCart.products.remove(product)
                return true
            }
        }
        return false
    }

    fun addProduct(product: Product, qty: Int): Boolean {
        if (shoppingCart.products.isEmpty()) {
            shoppingCart.products.put(product, qty)
            return true
        }
        if (!shoppingCart.products.contains(product)) {
            shoppingCart.products[product] = qty
            println(shoppingCart.products[product])
            return true
        }
        if (shoppingCart.products.contains(product)) {
            var temporal = shoppingCart.products[product]
            var new = temporal!! + qty
            shoppingCart.products[product] = new
            println(shoppingCart.products[product])
            return true
        }

        return false
    }
    fun getTotal():Int{
        var total =0
        shoppingCart.products.forEach(fun(product,cantidad){
            total += product.price * cantidad
        })

        return total
    }
}