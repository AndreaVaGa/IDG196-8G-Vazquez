package Clase_02_11

import java.time.LocalDate
import java.util.*

class Payment(id:String, numero : Int,  CSV : Int) {
    private val ID = id
    private val  numero = numero
    //private val anio= anio
    //private val mes= mes
    private val CSV = CSV

    /*fun getAnio(): Int{
        return anio
    }
    fun getMes(): Int{
        return mes
    }*/
    fun getNumero(): Int{
        return numero
    }
    fun getCSV(): Int{
        return CSV
    }
    fun getID(): String{
        return ID
    }

}