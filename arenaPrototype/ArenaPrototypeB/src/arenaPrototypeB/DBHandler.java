package arenaPrototypeB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler{
	
    Connection dbconnection;
    
    public Connection getConnection(){
        try {
           Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("ClassNOT FOUND ERROR - DBHandler");
        }
        try{
        dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arena","root","zilbot46");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("SQL ERROR - DBHandler");
        }
        return dbconnection;
    }
}
