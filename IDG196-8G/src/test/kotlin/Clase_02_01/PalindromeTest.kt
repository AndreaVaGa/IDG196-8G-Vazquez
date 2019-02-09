package Clase_02_01

import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PalindromeTest {
     private val Palindrome = Palindrome()

    @Test
    fun `returns false when number is negative `() {
        val value = -100
        assertFalse(Palindrome.ispalindrome(value))
    }

    @Test
    fun `returns false when number ends in 0 `() {
        val value = 10000
        assertFalse(Palindrome.ispalindrome(value))
    }

    @Test
    fun `returns true when 0 `() {
        val value = 0
        assertTrue(Palindrome.ispalindrome(value))
    }

    @Test
    fun `returns true when 3digit palindrome`() {
        val value = 121
        assertTrue(Palindrome.ispalindrome(value))
    }

    @Test
    fun `returns true when pair digits palindrome `() {
        val value = 2222
        assertTrue(Palindrome.ispalindrome(value))
    }
    @Test
    fun `returns true when 1 digit palindrome `() {
        val value = 2
        assertTrue(Palindrome.ispalindrome(value))
    }

}