import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object CockroachDBConnection {

    private const val URL = "jdbc:postgresql://free-cluster-2580.jxf.gcp-asia-southeast1.cockroachlabs.cloud:26257/smartfarm?sslmode=verify-full"
    private const val USER = "testuser"
    private const val PASSWORD = "123456Aa"

    fun connectAndFetchData() {
        var connection: Connection? = null
        try {
            Class.forName("org.postgresql.Driver")

            connection = DriverManager.getConnection(URL, USER, PASSWORD)

            val stmt: Statement = connection.createStatement()
            val rs: ResultSet = stmt.executeQuery("SELECT * FROM your_table")

            while (rs.next()) {
                println(rs.getString(1))
            }

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection?.close()
        }
    }
}
