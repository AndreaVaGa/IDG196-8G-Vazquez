package examen0301_2

class MachineBehavior {
    val dinero = arrayListOf<Int>()
    fun charge(total: Int, monto: Int): HashMap<Int, Int> {
        var cuanto = monto - total
        val cambio: HashMap<Int, Int> = hashMapOf()
        while (cuanto > 0) {
            var mayor = 0
            for (i in 0 until dinero.size) {
                if (dinero[i] > mayor && dinero[i] <= cuanto) {
                    mayor = dinero[i]
                }
            }
            if (cuanto % mayor != 0) {
                var tmp = cuanto % mayor
                var cuantotemp = cuanto - tmp
                cambio[mayor] = cuantotemp / mayor
                cuanto -= mayor * (cuantotemp / mayor)

            } else {
                cambio[mayor] = cuanto / mayor
                cuanto -= mayor * (cuanto / mayor)

            }

        }

        return cambio
    }


}