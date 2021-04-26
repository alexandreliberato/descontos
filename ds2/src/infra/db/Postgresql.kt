package infra.db

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class Postgresql {
    private var connection: Connection? = null

    fun getConnection(): Connection? {
        if (connection != null) {
            return connection
        } else {
            try {
                val props = Properties()
                props.setProperty("user", "postgres")
                props.setProperty("password", "postgres")
                props.setProperty("ssl", "false")

                connection = DriverManager.getConnection("jdbc:postgresql://postgres:5432/postgres", props)
                println("Connected to PostgreSQL database!")
            } catch (e: ClassNotFoundException) {
                println("PostgreSQL JDBC driver not found.");
                e.printStackTrace();
            } catch (e: SQLException) {
                println("Connection failure.")
                e.printStackTrace()
            }
        }

        return connection
    }
}