package tpi.sistema.de.carreras.TPI_Carreras;



public class TPISistemaDeCarreras {

    public static void main(String[] args) {
        ConexionDB dbc = new ConexionDB();  // Para una correcta conexion se debe crear de manera local una BD llamada "sistema_carrera" y...
        dbc.Conectar();                     // ... sus respectivas clases definidas en el diagrama de clases.
        // Se tiene que agregar una condicion que unicamente se ejecute el jFrame MainMenu si la conexion es exitosa.
        MainMenu menuPrincipal = new MainMenu();
        
        menuPrincipal.setVisible(true);
    }
}
