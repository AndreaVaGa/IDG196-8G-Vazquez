package examen0301

class MaquinaBehavior {
    var dinero: HashMap<Int,Int> = hashMapOf()
    fun addBills(denominación: Int, cantidad: Int): Boolean{
        if(dinero.isEmpty()){
            dinero[denominación]= cantidad
            return true
        }
        if(!dinero.containsKey(denominación)){
            dinero[denominación]= cantidad
            return true
        }
        if(dinero.containsKey(denominación)){
            var temporal = dinero[denominación]
            var new = temporal!! + cantidad
            dinero[denominación] = new
            print(dinero[denominación])
            return true
        }
        return false
    }

    fun charge(Total:Int, Recibido:Int): HashMap<Int,Int>{
        val cuanto = Recibido-Total
        val cambio :HashMap<Int, Int> = hashMapOf()
            dinero.forEach(fun(denominacion, qty){
                var mayor = 0
                if(denominacion>mayor && denominacion<cuanto){
                    mayor= denominacion
                }

                cambio[mayor]= cuanto/mayor
            })

        return cambio

    }


}