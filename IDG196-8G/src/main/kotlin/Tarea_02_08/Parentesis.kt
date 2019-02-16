package Tarea_02_08

import java.util.*

class Parentesis {

    fun isAValidExpression(string: String): Boolean {
        if (string.isEmpty()) {
            return false
        }

        var pila: Stack<Char> = Stack()
        for (i in 0 until string.length) {

            if (string[i] == '(' || string[i] == '{' || string[i] == '[') {
                pila.push(string[i])
            }
            else if (string[i] == ')'&& pila[pila.size-1]=='(') {
                pila.pop()
            }
            else if (string[i] == '}' && pila[pila.size - 1] == '{') {
                pila.pop()
            }
            else if (string[i] == ']' && pila[pila.size - 1] == '[') {
                pila.pop()
            }

            if (pila.empty()) {
                return true
            }
        }

        return false

        /* if (string.length % 2 != 0) {
            return false
        }
        for (i in 0 until string.length - 1) {

            if (string[i] == '(' || string[i] == '{' || string[i] == '[' || string[i] == ')' || string[i] == '}' || string[i] == ']') {
                if (string[0] == ')' || string[i] == '}' || string[i] == ']') {
                    return false
                }
                return true
            }
        }*/
    }
}