package tpi.sistema.de.carreras.TPI_Carreras;

import java.sql.*;
import java.text.SimpleDateFormat; 

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

// ADD ------------------------------------------------------------------------------------------------------
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
      
        public static Connection Add(String newUser, String newPassword, String newVehicle) // Se agrega un nuevo Administrador
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
// DELETE ------------------------------------------------------------------------------------------------------
// UPDATE ------------------------------------------------------------------------------------------------------
// COMBOBOX ------------------------------------------------------------------------------------------------------
     public static java.util.List<String> comboboxRace() {
    java.util.List<String> nombres = new java.util.ArrayList<>();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        con = Conectar();
        String query = "SELECT DISTINCT t.name FROM race r INNER JOIN track t ON r.IDTRACK = t.id";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();

        while (rs.next()) {
            nombres.add(rs.getString("name"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return nombres;
}

    public static java.util.List<String> comboboxDate(String trackName) {
        java.util.List<String> dates = new java.util.ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conectar();
            String query = """
            SELECT
                r.date
            FROM track t
                INNER JOIN race r ON r.IDTRACK = t.id
            WHERE t.name = ?
            ORDER BY r.date
            """;

        pst = con.prepareStatement(query);
        pst.setString(1, trackName);
        rs = pst.executeQuery();

        SimpleDateFormat outFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (rs.next()) {
            java.sql.Date dateSQL = rs.getDate("date");
            String formatedDate = outFormat.format(dateSQL);
            dates.add(formatedDate);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return dates;
}
// TABLE ------------------------------------------------------------------------------------------------------
    public static java.util.List<String[]> searchPlayers(String track, java.sql.Date date) {
    java.util.List<String[]> list = new java.util.ArrayList<>();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        con = Conectar();
        String query = """
            SELECT 
                u.nick, 
                u.vehicle, 
                ux.position
            FROM race r
            JOIN track t ON r.IDTRACK = t.id
            JOIN userxrace ux ON ux.IDRACE = r.id
            JOIN user u ON u.id = ux.IDUSER
            WHERE t.name = ? AND r.date = ?
            ORDER BY ux.position
        """;

        pst = con.prepareStatement(query);
        pst.setString(1, track);
        pst.setDate(2, date);
        rs = pst.executeQuery();

        while (rs.next()) {
            String nick = rs.getString("nick");
            String vehicle = rs.getString("vehicle");
            String position = rs.getString("position");
            list.add(new String[] { nick, vehicle, position });
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return list;
    }
    
    public static java.util.List<String[]> getRaces() { // Carga de la Tabla de Carreras en MainMenuADM
        java.util.List<String[]> list = new java.util.ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conectar();
            String query = """
                SELECT 
                    r.id, 
                    r.lapAmount, 
                    r.date, 
                    t.name
                FROM race r
                INNER JOIN track t ON r.IDTRACK = t.id
                ORDER BY r.date
            """;

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String laps = String.valueOf(rs.getInt("lapAmount"));
                String date = String.valueOf(rs.getDate("date")); 
                String track = rs.getString("name");

                list.add(new String[] { id, laps, date, track });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
    
    public static java.util.List<String[]> getUsers() { // Carga de la Tabla de Usuarios en MainMenuADM
        java.util.List<String[]> list = new java.util.ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conectar();
            String query = "SELECT id, nick, vehicle FROM user";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nick = rs.getString("nick");
                String vehicle = rs.getString("vehicle");

                list.add(new String[] { id, nick, vehicle });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
    
    public static java.util.List<String[]> getAdmins() { // Carga de la Tabla de Administradores en MainMenuADM
        java.util.List<String[]> list = new java.util.ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conectar();
            String query = "SELECT id, nick FROM admin";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nick = rs.getString("nick");
                list.add(new String[] { id, nick });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public static java.util.List<String[]> getTracks() { // Carga de la Tabla de Circuitos en MainMenuADM
        java.util.List<String[]> list = new java.util.ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conectar();
            String query = """
                SELECT 
                    t.id, 
                    t.name, 
                    t.description, 
                   CONCAT(p.City, ', ', p.stateProvince, ', ', p.Country) AS location
                FROM track t
                JOIN place p ON t.POSTALCODE = p.postalCode
                ORDER BY t.name
            """;

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String desc = rs.getString("description");
                String place = rs.getString("location");

                list.add(new String[] { id, name, desc, place });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public static java.util.List<String[]> getPlaces() { // Carga de la Tabla de Ubicaciones en MainMenuADM
        java.util.List<String[]> list = new java.util.ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conectar();
            String query = """
                SELECT postalCode, City, stateProvince, Country
                FROM place
                ORDER BY Country, stateProvince, City
            """;

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String pCode = String.valueOf(rs.getInt("postalCode"));
                String city = rs.getString("City");
                String state = rs.getString("stateProvince");
                String country = rs.getString("Country");

                list.add(new String[] { pCode, city, state, country });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }


// LOG-IN -----------------------------------------------------------------------------
    public static boolean validateAdmin(String nick, String password) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean log = false;

        try {
            con = Conectar();
            String query = "SELECT * FROM admin WHERE Nick = ? AND Password = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, nick);
            pst.setString(2, password);

            rs = pst.executeQuery();
            log = rs.next(); // si existe una fila, es válido

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    return log;
    }
}
