package Clase_02_15


import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CartBehaviorTest {

    private val customer = Customer("Andrea", "andrea.garay@cetys.edu.mx")
    private val cart = customer.cart
    private val product = Product("Chocolate", "298745631", 18)
    @Before
    fun setup() {
        println("its a me setup")
        cart.products.clear()
    }

    @Test
    fun `remove product returns true if product list is empty`() {
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.removeProduct(product, 2))
    }

    @Test
    fun `can't remove a product that does not exist`() {
        cart.products[product] = 4
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        val nonExistingProduct = Product("Pastel", "132947827", 100)
        assertFalse(shoppingCartBehavior.removeProduct(nonExistingProduct, 7))
    }

    @Test
    fun `remove a product that exist`() {
        cart.products[product]= 3
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.removeProduct(product, 2))
    }
    @Test
    fun `remove more producths than existing`() {
        cart.products[product]= 3
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.removeProduct(product, 5))
    }

    @Test
    fun `add a product if products list is empty`() {
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        assertTrue(shoppingCartBehavior.addProduct(product, 4))
    }

    @Test
    fun `add a product that does not exist`() {
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        cart.products.put(product, 2)
        val nonExistingProduct = Product("Pastel", "132947827", 100)
        assertTrue(shoppingCartBehavior.addProduct(nonExistingProduct, 5))

    }

    @Test
    fun `add a product that exist`() {
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        cart.products.put(product, 3)
        assertTrue(shoppingCartBehavior.addProduct(product, 4))
    }

    @Test
    fun `return total`(){
        val shoppingCartBehavior = ShoppingCartBehavior(cart)
        cart.products.put(product, 5)
        val expected= 90
        val actual = shoppingCartBehavior.getTotal()
        assertEquals(expected,actual)
    }


}