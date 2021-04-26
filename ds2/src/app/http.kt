package app

import io.javalin.Javalin
import app.api.ProductAPI

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)

    app.get("/") { ctx -> ctx.result("Desafio Produtos x Descontos\nPara executar o sistema use /produtos") }

    app.get("/produtos") { ctx ->
        val idUser = ctx.header<String>("X-USER-ID")?.getOrNull()
    	val api = ProductAPI()
    	val results = api.lista(idUser)
	    ctx.json(results)
    }
}

 

