package mx.edu.cetys.garay.andrea

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Authentication) {
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        header("MyCustomHeader")
        allowCredentials = true
    }
    val customer = Customer("Andrea", "andrea.garay@cetys.edu.mx")
    val cardDigits = "4901123412341234"
    val cardCSV = "123"
    val cardExpire = "12/20"
    val payment = Payment(cardDigits, cardCSV, cardExpire)
    val cart = customer.cart
    val product = Product("Chocolate", "298745631", 18)
    val product2 = Product("Pie", "293445662", 20)
    val shoppingCartBehavior = ShoppingCartBehavior(cart)
    val customerBehavior = CustomerBehavior(customer)
    customerBehavior.addPayment(payment)
    shoppingCartBehavior.addProduct(product,2)
    shoppingCartBehavior.addProduct(product2,5)

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/shoppingCart/customer") {
            call.respond(mapOf("customer" to customer.name ))
        }
        get("/shoppingCart/products") {
            call.respond(mapOf("products" to customer.cart.products))
        }
        get("/shoppingCart/total") {
            call.respond(mapOf("Total" to shoppingCartBehavior.getTotal()))
        }
        get("/customer/payments") {
            call.respond(mapOf("Payments" to customer.payments))
        }



    }
}

