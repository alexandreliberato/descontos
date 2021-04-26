package app.api

import domain.service.ProdutosService
import infra.db.ProductsRepository
import model.Product

class ProductAPI {
	private val service = ProdutosService(ProductsRepository())
	fun lista(idUser: String?): List<Product> {
		//TODO verificar usuario num servidor de identidades
		return service.lista(idUser)
	}
}

