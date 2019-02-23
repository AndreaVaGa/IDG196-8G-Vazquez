package Clase_02_15

import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CustomerBehaviorTest {
    private val cardDigits = "4901123412341234"
    private val cardCSV = "123"
    private val cardExpire = "12/20"

    private val payment = Payment(cardDigits, cardCSV, cardExpire)
    private val customer = Customer(
        "John Wayne",
        "jwayne@example.com"
    )
    private val cart = customer.cart
    private val product = Product("Chocolate", "298745631", 18)

    @Before
    fun setup() {
        println("its a me setup")
        customer.payments.clear()
    }

    @After
    fun teardown() {
        println("its a me teardown")
    }

    @Test
    fun `remove payment returns true if payments list is empty`() {
        val customerBehavior = CustomerBehavior(customer)
        assertTrue(customerBehavior.removePayment(payment))
    }

    @Test
    fun `can't remove a payment that does not exist`() {
        customer.payments.add(payment)

        val customerBehavior = CustomerBehavior(customer)
        val nonExistingPayment = Payment("10291019202920292", "132", "10/10")
        assertFalse(customerBehavior.removePayment(nonExistingPayment))
    }

    @Test
    fun `remove a payment that exists`() {
        customer.payments.add(payment)

        val customerBehavior = CustomerBehavior(customer)
        assertTrue(customerBehavior.removePayment(payment))
    }

    @Test
    fun ` add a new payment when payments list is empty`() {
        val customerBehavior = CustomerBehavior(customer)
        assertTrue(customerBehavior.addPayment(payment))
    }

    @Test
    fun `can't add a payment that already exist`() {
        customer.payments.add(payment)
        val customerBehavior = CustomerBehavior(customer)
        assertFalse(customerBehavior.addPayment(payment))
    }

    @Test
    fun `can add a payment that does not exist`() {
        customer.payments.add(payment)

        val customerBehavior = CustomerBehavior(customer)
        val nonExistingPayment = Payment("10291019202920292", "132", "10/10")
        assertTrue(customerBehavior.addPayment(nonExistingPayment))
    }
    @Test
    fun `pay cart`(){
        cart.products[product] = 4
        val customerBehavior = CustomerBehavior(customer)
        customer.payments.add(payment)
        assertTrue(customerBehavior.pay(payment))

    }

}
