package tpi.sistema.de.carreras.TPI_Carreras;
import java.sql.*;

public class ConexionDB {
    static String url = "jdbc:mysql://localhost:3306/sistema_carreras";
    static String user = "root";
    static String pass = "";
    
    public static Connection Conectar(){
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa.\n");
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error de conexion.\n");
        }
        
        return con;
    }
    
}
