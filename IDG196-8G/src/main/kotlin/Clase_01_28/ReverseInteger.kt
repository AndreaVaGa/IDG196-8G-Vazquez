package Clase_01_28

class ReverseInteger {
    /*fun reverseInt(numero: Int): Int
    {
        var cantidad = numero.toString().length
        var alreves = ""
        if(numero>=0)
        {
            for (i in cantidad until 0){
                numero.toString()[i]
                print(numero.toString()[i])
                alreves +=numero.toString()[i]
            }

        }
        else
        {
            alreves = "-"
            for (i in cantidad until 1){
                alreves += numero.toString()[i]
            }

        }
        return alreves.toInt()
    }*/

    fun reverseInteger(numero: Int):Int {
        var tmp1: Int = numero
        var digit: Int
        var reverse = 0
        while (tmp1 != 0) {
            digit = tmp1 %10
            tmp1 /= 10
            reverse= reverse *10 + digit
        }
        return reverse
    }
}