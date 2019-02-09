package Clase_02_01

class Palindrome {


    fun ispalindrome(x: Int): Boolean {

        if (x < 0) {
            return false
        }
        if (x % 10 == 0 && x != 0) {
            return false
        }

        var tmp1: Int = x
        var digit: Int
        var reverse = 0
        while (tmp1 > reverse) {
            digit = tmp1 % 10
            tmp1 /= 10
            reverse = reverse * 10 + digit
        }

        return (tmp1 == reverse || tmp1 == reverse / 10)
    }
}