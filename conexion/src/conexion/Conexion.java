package conexion;
import java.sql.*;
public class Conexion {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = 
                    DriverManager.getConnection("jdbc:mysql://50.62.209.73/inf282", 
                            "inf282", "inf282lp2");
            System.out.println("La conexion se ha realizado");
            Statement sentencia = con.createStatement();

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
