package tpi.sistema.de.carreras;

import tpi.sistema.de.carreras.TPI_Carreras.ConexionDB;

public class TPISistemaDeCarreras {

    public static void main(String[] args) {
        ConexionDB dbc = new ConexionDB();
        dbc.Conectar();
    }
    
}
