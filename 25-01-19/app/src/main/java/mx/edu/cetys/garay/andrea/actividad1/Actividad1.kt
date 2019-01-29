package mx.edu.cetys.garay.andrea.actividad1

class Actividad1 {
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
}