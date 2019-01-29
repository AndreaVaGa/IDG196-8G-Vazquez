package mx.edu.cetys.garay.andrea.actividad1

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private fun Posiciones(arreglo: IntArray, Suma:Int): IntArray {

        for (i in 0 until arreglo.size-1) {
            for(j in i + 1 until arreglo.size-1)
            {
                if(arreglo[i]+arreglo[j]== Suma)
                {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(0,0)

    }

    @Test
    fun PosicionesTest() {
        var arreglito = intArrayOf(9,6,4,8,1)
        var resultado = intArrayOf(2,3)
        assertEquals(resultado.get(0), Posiciones(arreglito,12).get(0))
        assertEquals(resultado.get(1),Posiciones(arreglito,12).get(1))
    }
}
