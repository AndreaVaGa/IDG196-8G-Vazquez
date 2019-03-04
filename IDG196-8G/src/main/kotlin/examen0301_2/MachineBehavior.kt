package examen0301_2

class MachineBehavior {
    val dinero = arrayListOf<Int>()
    fun charge(total: Int, monto: Int): HashMap<Int, Int> {
        var cuanto = monto - total
        val cambio: HashMap<Int, Int> = hashMapOf()
        dinero.sortDescending()

        if (monto < total) {
            println("falta dinero")
            return cambio
        }
        if (dinero.isEmpty()) {
            println("caja vacía")
            return cambio
        }
        if (cuanto % dinero[dinero.size - 1] != 0) {
            println("no hay suficientes monedas")
            return cambio
        }

        for (i in 0 until dinero.size) {
            if (dinero[i] <= cuanto) {
                var tmp = cuanto % dinero[i]
                var cuantotemp = cuanto - tmp
                cambio[dinero[i]] = cuantotemp / dinero[i]
                cuanto -= dinero[i] * (cuantotemp / dinero[i])
            }

        }

        return cambio
    }


}