package examen0301_2

import Clase_02_15.Customer
import Clase_02_15.Product
import Clase_02_15.ShoppingCartBehavior
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MachineTest {
    private val customer = Customer("Andrea", "andrea.garay@cetys.edu.mx")
    val cart = customer.cart
    val product = Product("Chocolate", "298745631", 18)
    val shoppingCartBehavior = ShoppingCartBehavior(cart)
    val machineBehavior = MachineBehavior()
    val cambio: HashMap<Int, Int> = hashMapOf()
    val total = 20
    val monto = 50
    @Before
    fun setup() {
        println("its a me setup")
        machineBehavior.dinero.clear()
        cambio.clear()
        customer.cart.products.clear()
    }

    @Test
    fun `return empty hashMap if it does not have money`() {
        assertEquals(cambio, (machineBehavior.charge(total, monto)))
    }

    @Test
    fun `return 3 coins of 10`() {
        machineBehavior.dinero.add(10)
        cambio[10] = 3
        assertEquals(cambio, (machineBehavior.charge(total, monto)))
    }

    @Test
    fun `return empty if it does not have enough denominations`() {
        machineBehavior.dinero.add(10)
        assertEquals(cambio, (machineBehavior.charge(48, monto)))
    }

    @Test
    fun `return 5 coins of 5`() {
        machineBehavior.dinero.add(5)
        cambio[5] = 5
        Assert.assertEquals(cambio, (machineBehavior.charge(25, monto)))

    }

    @Test
    fun `return 1 coin of 5 and 2 20 bills`() {
        machineBehavior.dinero.add(5)
        machineBehavior.dinero.add(20)
        cambio[5] = 1
        cambio[20] = 2
        assertEquals(cambio, (machineBehavior.charge(5, monto)))

    }

    @Test
    fun `return 1 coin of 5 and 2 20 bills and 2 200 bills`() {
        machineBehavior.dinero.add(5)
        machineBehavior.dinero.add(200)
        machineBehavior.dinero.add(20)
        cambio[5] = 1
        cambio[200] = 2
        cambio[20] = 2
        assertEquals(cambio, (machineBehavior.charge(55, 500)))

    }

    @Test
    fun `return 10 when buying 5 chocolates and paying with 100 `() {
        machineBehavior.dinero.add(5)
        machineBehavior.dinero.add(10)
        machineBehavior.dinero.add(200)
        shoppingCartBehavior.addProduct(product, 5)
        val totalCarrito = shoppingCartBehavior.getTotal()
        cambio[10] = 1
        assertEquals(cambio, (machineBehavior.charge(totalCarrito, 100)))

    }

    @Test
    fun `return 32 when buying 1 chocolate and paying with 50 `() {
        machineBehavior.dinero.add(1)
        machineBehavior.dinero.add(10)
        machineBehavior.dinero.add(20)
        shoppingCartBehavior.addProduct(product, 1)
        val totalCarrito = shoppingCartBehavior.getTotal()
        cambio[10] = 1
        cambio[20] = 1
        cambio[1] = 2
        assertEquals(cambio, (machineBehavior.charge(totalCarrito, 50)))


    }

}