package tpi.sistema.de.carreras.TPI_Carreras;

import java.sql.*;

public class ConexionDB {
    static String url = "jdbc:mysql://localhost/sistema_carreras"; //"jdbc:mysql://localhost/sistema_carreras";
    static String user = "root";
    static String pass = "";
    
    public static Connection Conectar(){ // Conexion inicial del sistema, principalmente utilizada para que se valide que esta todo bien
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa.\n");
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        
        return con;
    }

    /**
     *
     * @param newUser
     * @param newVehicle
     * @return
     */
    public static Connection Add(String newUser, String newVehicle) // Se agrega un nuevo Usuario
    {
        Connection con = null;
        
        try
        {
            String query = "INSERT INTO user(Nick, Vehicle) VALUES (?, ?)";
            con = Conectar();
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newUser);
            pst.setString(2, newVehicle);
            
            pst.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error de conexion.\n");
        }
        
        return con;
    }
      
        public static Connection Add(String newUser, String newPassword, String newVehicle) // Se agrega un nuevo Administador
    {
        Connection con = null;
        
        try
        {
            String query = "INSERT INTO admin(Nick, Password, Vehicle) VALUES (?, ?, ?)";
            con = Conectar();
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newUser);
            pst.setString(2, newPassword);
            pst.setString(3, newVehicle);
            
            pst.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error de conexion.\n");
        }
        
        return con;
    }
}
