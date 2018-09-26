/*RCF-2018--Scala-2.10------<-min-width-80-chars->-----------------------------
 *
 * { Course Notes: Scala Essential Training for Data Science }
 * 
 * Utilizing PostgreSQL
 *  Scala can draw on the vast number of Java libraries.
 * 
 * Getting Fine' PostgreSQL working:
 *  1. Install PostgreSQL on GNU/Linux using whatever instructions.
 *  2. Execute in bash: systemctl enable postgresql-10
 *  3. Execute in bash: systemctl start postgresql-10
 *  4. Setup your database and users. Import data.
 *  5. Find out where your pg_hba.conf file is located by running in psql:
 *      show hba_file
 *  6. Modify the hba file to trust users from... 
 *         (You'll have to figure this out yourself.)
 */

import java.sql.DriverManager
import java.sql.Connection

val driver = "org.postgresql.Driver"
var url = "jdbc:postgresql://localhost/scala_db?user=rflec028"

Class.forName(driver)

var connection: Connection = null

connection = DriverManager.getConnection(url)
val statement = connection.createStatement() //Like a cursor, an iterable ting
val resultSet = statement.executeQuery("select * from emps")

println("Result in set? >> "+resultSet.next)
println("Property of first result? >> "+resultSet.getString("last_name"))

// It works!
