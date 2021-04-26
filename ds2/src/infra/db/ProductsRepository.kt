package infra.db

import model.Product
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class ProductsRepository {

    fun lista(): List<Product> {
        var connection = Postgresql().getConnection()
        var products = mutableListOf<Product>()

        if (connection == null) {
            println("x erro ao conectar na base de dados!")
            return products
        }

        try {
            val statement: Statement = connection.createStatement()
            println("> reading records...")

            val resultSet: ResultSet = statement.executeQuery("SELECT * FROM products")
            while (resultSet.next()) {
                val p = Product(
                    id = resultSet.getString("id"),
                    title = resultSet.getString("title"),
                    description = resultSet.getString("description"),
                    priceInCents = resultSet.getInt("price_in_cents"),
                    discount = model.Discount(0f,0)
                )

                products.add(p)

                System.out.printf(
                    "> %s, %s",
                    p.id,
                    p.title
                )
            }
        } catch(e: SQLException) {
            e.printStackTrace()
        } finally {
            connection?.close()
        }

        return products
    }
}