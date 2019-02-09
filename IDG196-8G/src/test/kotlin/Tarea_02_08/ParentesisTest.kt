package Tarea_02_08

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ParentesisTest {
    private val Parentesis = Parentesis();

    @Test
    fun `returns false when invalid character`() {
        val string = "aa"
        assertFalse(Parentesis.isAValidExpression(string))
    }
    @Test
    fun `returns false when start with closing parentesis`() {
        val string = ")("
        assertFalse(Parentesis.isAValidExpression(string))
    }
    @Test
    fun `returns true when valid character`() {
        val string = "()"
        assertTrue(Parentesis.isAValidExpression(string))
    }


    @Test
    fun `returns false when impair characters`() {
        val string = "}]}"
        assertFalse(Parentesis.isAValidExpression(string))
    }
    @Test
    fun `returns false when wrong order`() {
        val string = "([)]"
       assertFalse(Parentesis.isAValidExpression(string))
    }




}