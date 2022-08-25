import java.sql.DriverManager
//model class
data class User(val id:Int,val name: String)

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/sampledb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "Arvinth@97")
    println(connection.isValid(0))
    //insert query - create
    val insert_res = connection.createStatement().executeUpdate("insert into users(id,name)values(7,'Anoop')")
    if(insert_res>0){
        println("successfully inserted record into users db !!!")
    }else{
        println("Insert not successful")
    }
    //delete query - delete

    val delete_res = connection.createStatement().executeUpdate("delete from users where id = 2")
    if(delete_res>0){
        println("successfully deleted record into users db !!!")
    }else {
        println("delete not successful")
    }

    //update query - update
    val update_res = connection.createStatement().executeUpdate("update users set name = 'sriraksha' where id = 4")
    if(update_res>0){
        println("successfully updated record in user")
    }else{
        println("update not successful")
    }

    //fetch records from database //select query - Read
    val query = connection.prepareStatement("select * from users")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while(result.next()){
        val id = result.getInt("id")
        val name = result.getString("name")
        users.add(User(id,name))
    }
    println(users)
}



