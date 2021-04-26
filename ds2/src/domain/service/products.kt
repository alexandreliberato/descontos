package domain.service

import infra.db.ProductsRepository
import infra.grpc.DiscountClient
import model.Product
import org.slf4j.LoggerFactory

class ProdutosService(private val repository: ProductsRepository) {
	private val logger = LoggerFactory.getLogger(ProdutosService::class.java)

    fun lista(idUser: String?): List<Product> {
		val products = repository.lista()

        products.forEach { item ->
                logger.info("> buscando desconto para: $item")
                val discount = DiscountClient().getDiscount(idUser, item.id)
                item.discount = discount
            }

		return products
	}
}
