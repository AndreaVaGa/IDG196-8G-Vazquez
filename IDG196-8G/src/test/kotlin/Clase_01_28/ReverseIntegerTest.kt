package Clase_01_28

import org.junit.Assert.assertEquals
import org.junit.Test

class ReverseIntegerTest {
    private val reverseInteger = ReverseInteger()

    @Test
    fun TestReverseInt()
    {
        val value = 1234
        val expected = 4321
        val actual = reverseInteger.reverseInteger(value)
        assertEquals(expected,actual)
    }

    @Test
    fun TestifReverseNegativeInt()
    {
        val value = -1234
        val expected = -4321
        val actual = reverseInteger.reverseInteger(value)
        assertEquals(expected,actual)
    }
}