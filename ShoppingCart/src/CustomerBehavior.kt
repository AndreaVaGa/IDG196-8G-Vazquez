package mx.edu.cetys.garay.andrea

class CustomerBehavior(private val customer: Customer) {

    fun removePayment(payment: Payment): Boolean {
        if (customer.payments.isEmpty()) {
            return true
        }
        if (customer.payments.contains(payment)) {
            return customer.payments.remove(payment)
        }
        return false
    }

    fun addPayment(payment: Payment): Boolean {
        if (customer.payments.isEmpty()) {
            return customer.payments.add(payment)
        }
        if (!customer.payments.contains(payment)) {
            return customer.payments.add(payment)
        }
        return false
    }

    fun pay(payment: Payment):Boolean{
        if(customer.payments.contains(payment)){
            customer.cart.products.clear()
            return  true
        }
        return false

    }

}