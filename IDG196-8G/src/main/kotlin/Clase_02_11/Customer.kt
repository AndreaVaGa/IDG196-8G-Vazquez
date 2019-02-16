package Clase_02_11

class Customer(name: String, email: String) {

    private val ID = null
    private val name = name
    private val email = email
    private val pagos = arrayListOf<Payment>()

    fun getName(): String {
        return name
    }

    fun getEmail(): String {
        return email
    }

    fun addPayment(tarjeta: Payment): Boolean {

        if (pagos.isEmpty()) {
            pagos.add(tarjeta)
            return true
        }

        for (i in 0 until pagos.size - 1) {
            if (tarjeta.getNumero() == pagos[i].getNumero()) {
                return false
            }
        }
        pagos.add(tarjeta)

        return true

    }
    fun removePayment(numero: Int){
        if(pagos.isEmpty()){
            println("No hay tarjetas para eliminar")
        }
        else{

            for (i in 0 until pagos.size-1){
                if(pagos[i].getNumero()==numero){
                    pagos.removeAt(i)
                }
            }
        }
    }


}