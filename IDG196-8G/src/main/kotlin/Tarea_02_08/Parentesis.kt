package Tarea_02_08

class Parentesis {

    fun isAValidExpression(string: String): Boolean {

        if (string.length % 2 != 0) {
            return false
        }
        for (i in 0 until string.length-1) {
            if (string[i] == '(' || string[i] == '{' || string[i] == '[' || string[i] == ')' || string[i] == '}' || string[i] == ']') {
                if(string[0]== ')' || string[i] == '}'|| string[i] ==']'){
                    return false
                }

                return true
            }

        }


        return false
    }
}