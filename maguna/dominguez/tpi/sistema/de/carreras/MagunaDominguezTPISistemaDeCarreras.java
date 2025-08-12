    /*********************************************************************************************************/
   /*  @brief Trabajo Practico Grupal Integrador, Programacion III y Base de Datos II, Sistema de Carreras  */
  /*  @author Maguna Thumm, Maximo Galo                                                                    */
 /*  @author Dominguez, Ezequiel                                                                          */
/*********************************************************************************************************/

package maguna.dominguez.tpi.sistema.de.carreras;

import JFrames.MainMenu;

public class MagunaDominguezTPISistemaDeCarreras {

    public static void main(String[] args) {
        ConnectionDB dbc = new ConnectionDB();  
        dbc.Connect();                     
        MainMenu menuPrincipal = new MainMenu();
        
        menuPrincipal.setVisible(true);
    }
    
}
