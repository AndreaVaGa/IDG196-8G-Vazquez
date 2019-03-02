package examen0301

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MaquinaTest {

    val maquinaBehavior = MaquinaBehavior()
    val total =20
    val monto = 50


    @Test
    fun `add money return true when machine is empty`(){
        assertTrue(maquinaBehavior.addBills(100,50))
    }
    @Test
    fun `return tue when adding money that does not exist`(){
        maquinaBehavior.addBills(20,30)
        assertTrue(maquinaBehavior.addBills(100,50))
    }
    @Test
    fun `return tue when adding money that already exist`(){
        maquinaBehavior.addBills(100,30)
        assertTrue(maquinaBehavior.addBills(100,50))
    }

    @Test
    fun `return the change is correct whit one denomination`(){
        maquinaBehavior.addBills(10,20)
        maquinaBehavior.charge(total, monto)
        val cambio : HashMap<Int,Int> =  hashMapOf()
        cambio[10]=3
        assertEquals(cambio,(maquinaBehavior.charge(total, monto)))
    }
    @Test
    fun `return the change correct`(){

    }



}