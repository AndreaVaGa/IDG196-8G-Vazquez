package Clase_02_11


import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CustomerTest {
    val Customer =Customer("Andrea", "andrea.garay@cetys.edu.mx")
    val Payment = Payment("Visa", 29057694, 345)

    @Test
    fun `Get Customer name`(){
        val expected = "Andrea"
        val actual = Customer.getName()
        assertEquals(expected,actual)
    }
    @Test
    fun `Get Customer email`(){
        val expected = "andrea.garay@cetys.edu.mx"
        val actual = Customer.getEmail()
        assertEquals(expected,actual)
    }

    @Test
    fun `Add payment`(){
        assertTrue(Customer.addPayment(Payment))
    }


}