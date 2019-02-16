package Clase_02_11

import java.util.*

class ShoppingCart {
    private val productos = arrayListOf<Product>()
    private var Customer = arrayListOf<Customer>()
    private var isActive = 0
    //private val fecha : Date()

    fun addCustomer(customer: Customer): Int{

        if(isActive==0){
            Customer.add(customer)
            isActive = 1
            return isActive
        }
        else{
            println("Ya existe un cliente")
            return isActive
        }
    }
    fun removeCustomer():Int{
        if(isActive==0)
            {
                println("No hay clientes")
                return isActive
            }
        else{
            Customer.removeAt(0)
            isActive=0
            return isActive
        }

    }


    fun addProduct( producto: Product): Boolean{
        if(productos.isEmpty()){
            productos.add(producto)
            return true
        }

        return false
    }
}