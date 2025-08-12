/******************************************************************************************************************************** 
    
    
    * @about    We introduced dummy parameters in multiple locations to enable the use of polymorphism. These dummy 
                parameters are non-functional data used solely to differentiate method signatures. However, for the final 
                Select methods, it is necessary to append distinctive identifiers to their names to avoid duplication and improve clarity.
                
*********************************************************************************************************************************/

package maguna.dominguez.tpi.sistema.de.carreras;

import Clases.*;

import java.sql.*;
import java.util.*;
import java.sql.Date;

public class ConnectionDB {
    static String url = "jdbc:sqlserver://206.189.237.186:14111;databaseName=Maguna_Dominguez_TPI_Progra3xBBDD2_sistema_carreras"; 
    static String user = "edominguez";
    static String pass = "";
    
    public static Connection Connect(){ 
        Connection connection = null;
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa a SQL Server");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }

        return connection;
    }

// ----------------------------------------------------------------------------- SELECT //
    public static Admin Select(int id) { // SEARCH ADMIN BY ID
        Connection conn = Connect();
        Admin admin = null;

        if (conn != null) {
            String sql = "SELECT nick, psw FROM adm WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String nick = rs.getString("nick");
                    String password = rs.getString("psw");
                    admin = new Admin(nick, password);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }

        return admin;
    }
    
    public static Place Select(String postalCode) { // SEARCH PLACE BY POSTAL CODE
        Connection conn = Connect();
        Place place = null;

        if (conn != null) {
            String sql = "SELECT city, stateProvince, country FROM place WHERE postalCode = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, postalCode);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String city = rs.getString("city");
                    String state = rs.getString("stateProvince");
                    String country = rs.getString("country");

                    place = new Place(postalCode, city, state, country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }

        return place;
    }
    
    public static List<String> SelectAllPostalCodes() { // SEARCH ALL POSTAL CODE
        List<String> codigos = new ArrayList<>();
        Connection conn = Connect();

        if (conn != null) {
            String sql = "SELECT postalCode FROM place";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    codigos.add(rs.getString("postalCode"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return codigos;
    }
    
    public static Track Select(int id, int dummy) { // SEARCH TRACK BY ID
        Connection conn = Connect();
        Track track = null;

        if (conn != null) {
            String sql = "SELECT name, description, POSTALCODE FROM track WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String postalCode = rs.getString("POSTALCODE");

                    track = new Track(name, description, postalCode);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return track;
    }

    public static User Select(int id, String dummy) { // SEARCH USER BY ID
        Connection conn = Connect();
        User usr = null;

        if (conn != null) {
            String sql = "SELECT nick, vehicle FROM usr WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String nick = rs.getString("nick");
                    String vehicle = rs.getString("vehicle");
                    usr = new User(nick, vehicle);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return usr;
    }
    
    public static List<String> Select() { // FILL COMBO BOX IN ADD RACE
        List<String> items = new ArrayList<>();
        Connection conn = Connect();

        if (conn != null) {
            String sql = "SELECT id, name FROM track";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    items.add(id + " - " + name);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return items;
    }

    public static Race Select(int raceId, boolean dummy) { // GET RACE BY ID
        Race race = null;
        Connection conn = Connect();

        if (conn != null) {
            String sql = "SELECT lapAmount, date, IDTRACK FROM race WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, raceId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int laps = rs.getInt("lapAmount");
                    Date date = rs.getDate("date");
                    int idTrack = rs.getInt("IDTRACK");

                    race = new Race(raceId, laps, date, idTrack);
                }

                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return race;
    }
    
    public static List<String[]> SelectTable(char dummy) { // FILL TABLE RACE IN MAIN MENU ADM 
        List<String[]> races = new ArrayList<>();

        String sql = "SELECT race.id, race.lapAmount, race.date, track.id, track.name " +
                     "FROM race JOIN track ON race.IDTRACK = track.id";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String laps = String.valueOf(rs.getInt("lapAmount"));
                String date = rs.getString("date");
                String track = rs.getInt("track.id") + " - " + rs.getString("track.name");

                races.add(new String[]{id, laps, date, track});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return races;
    }

    public static List<String[]> SelectTable(int dummy) { // FILL TABLE USER IN MAIN MENU ADM
        List<String[]> users = new ArrayList<>();

        String sql = "SELECT id, nick, vehicle FROM usr";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nick = rs.getString("nick");
                String vehicle = rs.getString("vehicle");

                users.add(new String[]{id, nick, vehicle});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static List<String[]> SelectTable() { // FILL TABLE ADMIN IN MAIN MENU ADM
        List<String[]> admins = new ArrayList<>();

        String sql = "SELECT id, nick FROM adm";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nick = rs.getString("nick");

                admins.add(new String[]{id, nick});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }

    public static List<String[]> SelectTable(String dummy) { // FILL TABLE TRACK IN MAIN MENU ADM
        List<String[]> tracks = new ArrayList<>();

        String sql = "SELECT id, name, description, POSTALCODE FROM track";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String description = rs.getString("description");
                String postalCode = rs.getString("POSTALCODE");

                tracks.add(new String[]{id, name, description, postalCode});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }
    
    public static List<String[]> SelectTable(boolean dummy) { // FILL TABLE PLACE IN MAIN MENU ADM
        List<String[]> places = new ArrayList<>();

        String sql = "SELECT postalCode, city, stateProvince, country FROM place";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String postalCode = rs.getString("postalCode");
                String city = rs.getString("city");
                String stateProvince = rs.getString("stateProvince");
                String country = rs.getString("country");

                places.add(new String[]{postalCode, city, stateProvince, country});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return places;
    }

    public static boolean SelectAdmin(String nick, String password) { // VALIDATE IF IS A REAL ADMIN
        boolean valido = false;

        String sql = "SELECT COUNT(*) FROM adm WHERE nick = ? AND psw = ?";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nick);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                valido = rs.getInt(1) > 0;
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valido;
    }

    public static List<String> SelectCombo() { // FILL COMBO BOX TRACK IN MAIN MENU
        List<String> tracks = new ArrayList<>();
        String sql = "SELECT id, name FROM track";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String item = rs.getInt("id") + " - " + rs.getString("name");
                tracks.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tracks;
    }

    public static List<String> SelectCombo(int idTrack) { // FILL COMBO BOX DATE IN MAIN MENU
        List<String> dates = new ArrayList<>();
        String sql = "SELECT date FROM race WHERE IDTRACK = ? ORDER BY date";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTrack);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dates.add(rs.getDate("date").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dates;
    }
    
    public static List<String[]> SelectResult(int idTrack, String date) {
        List<String[]> results = new ArrayList<>();

        String sql = "SELECT u.nick, u.vehicle, ur.position " +
                     "FROM race r " +
                     "JOIN usrXrace ur ON r.id = ur.raceId " +
                     "JOIN usr u ON ur.userId = u.id " +
                     "WHERE r.IDTRACK = ? AND r.date = ? " +
                     "ORDER BY ur.position";

        try (Connection conn = Connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTrack);
            stmt.setDate(2, Date.valueOf(date)); // Convertir String a java.sql.Date
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nick = rs.getString("nick");
                String vehicle = rs.getString("vehicle");
                String position = String.valueOf(rs.getInt("position"));

                results.add(new String[]{nick, vehicle, position});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }


// ----------------------------------------------------------------------------- INSERT //
    public static boolean Insert(Admin admin) {
        Connection conn = Connect();

        if (conn != null) {
            String sql = "INSERT INTO adm (nick, psw) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, admin.getNick());
                stmt.setString(2, admin.getPassword());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }

    
   public static boolean Insert(Place place) { // PLACE
        Connection conn = Connect();

        if (conn != null) {
            String sql = "INSERT INTO place (postalCode, city, stateProvince, country) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, place.getPostalCode());
                stmt.setString(2, place.getCity());
                stmt.setString(3, place.getStateProvince());
                stmt.setString(4, place.getCountry());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }
    
    public static boolean Insert(Track track) { // TRACK
        Connection conn = Connect();

        if (conn != null) {
            String sql = "INSERT INTO track (name, description, POSTALCODE) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, track.getName());
                stmt.setString(2, track.getDescription());
                stmt.setString(3, track.getPostalCode());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // true si se insertó al menos una fila

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }

    
    public static boolean Insert(User user) { // USER
        Connection conn = Connect();

        if (conn != null) {
            String sql = "INSERT INTO usr (nick, vehicle) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, user.getNick());
                stmt.setString(2, user.getVehicle());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    
    public static void Insert(int laps, Date date, int idTrack, List<User> usuarios) { // RACE
        Connection conn = Connect();

        try {
            conn.setAutoCommit(false);

            String insertRaceSQL = "INSERT INTO race (lapAmount, date, IDTRACK) VALUES (?, ?, ?)";
            PreparedStatement raceStmt = conn.prepareStatement(insertRaceSQL, Statement.RETURN_GENERATED_KEYS);
            raceStmt.setInt(1, laps);
            raceStmt.setDate(2, date);
            raceStmt.setInt(3, idTrack);
            raceStmt.executeUpdate();

            ResultSet rs = raceStmt.getGeneratedKeys();
            if (!rs.next()) {
                conn.rollback();
                throw new SQLException("No se pudo obtener el ID de la carrera.");
            }
            int idRace = rs.getInt(1);

            String insertUsrSQL = "INSERT INTO usrXrace (IDRACE, IDUSR, position) VALUES (?, ?, ?)";
            PreparedStatement usrStmt = conn.prepareStatement(insertUsrSQL);

            for (User usr : usuarios) {
                usrStmt.setInt(1, idRace);
                usrStmt.setInt(2, usr.getId());
                usrStmt.setInt(3, usr.getPosition());
                usrStmt.addBatch();
            }

            usrStmt.executeBatch();
            conn.commit();

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


// ----------------------------------------------------------------------------- UPDATE //
    public static boolean Update(Admin admin) { // ADMIN
        Connection conn = Connect();

        if (conn != null) {
            String sql = "UPDATE adm SET nick = ?, psw = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, admin.getNick());
                stmt.setString(2, admin.getPassword());
                stmt.setInt(3, admin.getId());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // true si actualizó al menos una fila

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }
    
    public static boolean Update(Place place) { // PLACE
        Connection conn = Connect();

        if (conn != null) {
            String sql = "UPDATE place SET city = ?, stateProvince = ?, country = ? WHERE postalCode = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, place.getCity());
                stmt.setString(2, place.getStateProvince());
                stmt.setString(3, place.getCountry());
                stmt.setString(4, place.getPostalCode());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }

    
    public static boolean Update(Track track, int id) { // TRACK
        Connection conn = Connect();

        if (conn != null) {
            String sql = "UPDATE track SET name = ?, description = ?, POSTALCODE = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, track.getName());
                stmt.setString(2, track.getDescription());
                stmt.setString(3, track.getPostalCode());
                stmt.setInt(4, id);

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }

    
    public static boolean Update(User usr, int id) { // USER
        Connection conn = Connect();

        if (conn != null) {
            String sql = "UPDATE usr SET nick = ?, vehicle = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, usr.getNick());
                stmt.setString(2, usr.getVehicle());
                stmt.setInt(3, id);

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0; 

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    public static boolean Update(Race race) {
        Connection conn = Connect();
        if (conn != null) {
            String sql = "UPDATE race SET lapAmount = ?, date = ?, IDTRACK = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, race.getLapAmount());
                stmt.setDate(2, (java.sql.Date) race.getDate());
                stmt.setInt(3, race.getIDTRACK());
                stmt.setInt(4, race.getId());

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }



// ----------------------------------------------------------------------------- DELETE //
    public static boolean Delete(int id) { // ADMIN
        Connection conn = Connect();

        if (conn != null) {
            String sql = "DELETE FROM adm WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }
}