package Clase_02_15


import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CartBehaviorTest {

    private val customer = Customer("Andrea", "andrea.garay@cetys.edu.mx")
    private val cart = ShoppingCart(customer, "02-15-2019")
    private val product = Product("Chocolate", "298745631", 18, 2)
    @Before
    fun setup() {
        println("its a me setup")
        cart.products.clear()
    }

    @Test
    fun `remove product returns true if product list is empty`() {
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.removeProduct(product))
    }
    @Test
    fun `can't remove a product that does not exist`() {
        cart.products.add(product)

        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        val nonExistingProduct = Product("Pastel", "132947827", 100,1)
        assertFalse(shoppingCartBehavior.removeProduct(nonExistingProduct))
    }
    @Test
    fun `remove a product that exist`() {
        cart.products.add(product)
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.removeProduct(product))
    }

    @Test
    fun `add a product if products list is empty`(){
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.addProduct(product))
    }
    @Test
    fun `add a product if product exist`(){
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        cart.products.add(product)
        val sameProduct = Product("Chocolate", "298745631", 18, 4)
        assertTrue(shoppingCartBehavior.addProduct(sameProduct))
    }

}