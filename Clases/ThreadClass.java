package Clases;

import JFrames.ADM.MainMenuADM;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import maguna.dominguez.tpi.sistema.de.carreras.ConnectionDB;

public class ThreadClass {

    public static void runAdminLogin(JTextField userField, JPasswordField passwordField, JFrame currentFrame) {
        new Thread(() -> {
            String nick = userField.getText().trim();
            String password = new String(passwordField.getPassword());

            boolean valid = ConnectionDB.SelectAdmin(nick, password);

            SwingUtilities.invokeLater(() -> {
                if (valid) {
                    MainMenuADM mainMenu = new MainMenuADM();
                    mainMenu.setVisible(true);
                    currentFrame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }
    
    public static void fillTrackCombo(JComboBox<String> trackCombo) {
        new Thread(() -> {
            List<String> tracks = ConnectionDB.SelectCombo();

            SwingUtilities.invokeLater(() -> {
                trackCombo.removeAllItems();
                for (String track : tracks) {
                    trackCombo.addItem(track);
                }
            });
        }).start();
    }
    
    public static void fillTrackCombo(Consumer<List<String>> onSuccess) {
        new Thread(() -> {
            List<String> tracks = ConnectionDB.Select();

            SwingUtilities.invokeLater(() -> {
                onSuccess.accept(tracks);
            });
        }).start();
    }
    
    public static void fillTrackCombo(JComboBox<String> trackCombo, int dummy) {
        new Thread(() -> {
            List<String> tracks = ConnectionDB.Select();

            SwingUtilities.invokeLater(() -> {
                trackCombo.removeAllItems();
                for (String item : tracks) {
                    trackCombo.addItem(item);
                }
            });
        }).start();
    }
    
    public static void fillCodeCombo(JComboBox<String> codeCombo) {
        new Thread(() -> {
            List<String> codigos = ConnectionDB.SelectAllPostalCodes();

            SwingUtilities.invokeLater(() -> {
                codeCombo.removeAllItems();
                for (String codigo : codigos) {
                    codeCombo.addItem(codigo);
                }
            });
        }).start();
    }

    public static void fillDateCombo(JComboBox<String> dateCombo, int idTrack) {
        new Thread(() -> {
            List<String> dates = ConnectionDB.SelectCombo(idTrack);

            SwingUtilities.invokeLater(() -> {
                dateCombo.removeAllItems();
                for (String date : dates) {
                    dateCombo.addItem(date);
                }
            });
        }).start();
    }
    
    public static void updateDateComboFromTrackCombo(JComboBox<String> trackCombo, JComboBox<String> dateCombo) {
        new Thread(() -> {
            String selected = (String) trackCombo.getSelectedItem();
            if (selected != null && !selected.isEmpty()) {
                try {
                    int idTrack = Integer.parseInt(selected.split(" - ")[0]);

                    List<String> dates = ConnectionDB.SelectCombo(idTrack);

                    SwingUtilities.invokeLater(() -> {
                        dateCombo.removeAllItems();
                        for (String date : dates) {
                            dateCombo.addItem(date);
                        }
                    });
                } catch (NumberFormatException e) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "ID de circuito inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    });
                }
            }
        }).start();
    }

    public static void loadResultsTable(JComboBox<String> trackCombo, JComboBox<String> dateCombo, JTable resultTable) {
        String selectedTrack = (String) trackCombo.getSelectedItem();
        String selectedDate = (String) dateCombo.getSelectedItem();

        if (selectedTrack != null && !selectedTrack.isEmpty() && selectedDate != null && !selectedDate.isEmpty()) {
            new Thread(() -> {
                try {
                    int idTrack = Integer.parseInt(selectedTrack.split(" - ")[0]);

                    List<String[]> results = ConnectionDB.SelectResult(idTrack, selectedDate);

                    SwingUtilities.invokeLater(() -> {
                        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
                        model.setRowCount(0);
                        for (String[] row : results) {
                            model.addRow(row);
                        }
                    });
                } catch (NumberFormatException e) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "ID de circuito inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    });
                }
            }).start();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione circuito y fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public static void fillRaceTable(JTable raceTable) {
        new Thread(() -> {
            List<String[]> datos = ConnectionDB.SelectTable('a');
            DefaultTableModel model = (DefaultTableModel) raceTable.getModel();

            SwingUtilities.invokeLater(() -> {
                model.setRowCount(0);
                for (String[] fila : datos) {
                    model.addRow(fila);
                }
            });
        }).start();
    }

    public static void fillUsersTable(JTable userTable) {
        new Thread(() -> {
            List<String[]> datos = ConnectionDB.SelectTable(0);
            DefaultTableModel model = (DefaultTableModel) userTable.getModel();

            SwingUtilities.invokeLater(() -> {
                model.setRowCount(0);
                for (String[] fila : datos) {
                    model.addRow(fila);
                }
            });
        }).start();
    }

    public static void fillAdminTable(JTable adminTable) {
        new Thread(() -> {
            List<String[]> datos = ConnectionDB.SelectTable();
            DefaultTableModel model = (DefaultTableModel) adminTable.getModel();

            SwingUtilities.invokeLater(() -> {
                model.setRowCount(0);
                for (String[] fila : datos) {
                    model.addRow(fila);
                }
            });
        }).start();
    }

    public static void fillTrackTable(JTable trackTable) {
        new Thread(() -> {
            List<String[]> datos = ConnectionDB.SelectTable("dummy");
            DefaultTableModel model = (DefaultTableModel) trackTable.getModel();

            SwingUtilities.invokeLater(() -> {
                model.setRowCount(0);
                for (String[] fila : datos) {
                    model.addRow(fila);
                }
            });
        }).start();
    }

    public static void fillPlaceTable(JTable placeTable) {
        new Thread(() -> {
            List<String[]> datos = ConnectionDB.SelectTable(true);
            DefaultTableModel model = (DefaultTableModel) placeTable.getModel();

            SwingUtilities.invokeLater(() -> {
                model.setRowCount(0);
                for (String[] fila : datos) {
                    model.addRow(fila);
                }
            });
        }).start();
    }
    
    public static void searchAdminById(int id, JTextField nickField, JPasswordField passwordField, Consumer<Admin> admSetter) {
        new Thread(() -> {
            Admin adm = ConnectionDB.Select(id);

            SwingUtilities.invokeLater(() -> {
                if (adm != null) {
                    nickField.setText(adm.getNick());
                    passwordField.setText(adm.getPassword());
                    admSetter.accept(adm);  // Para asignar adm a variable local si necesitás
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un administrador con ese ID.");
                }
            });
        }).start();
    }

    public static void updateAdmin(Admin adm, JFrame currentFrame, JTextField nickField, JPasswordField passwordField) {
        new Thread(() -> {
            adm.setNick(nickField.getText());
            adm.setPassword(new String(passwordField.getPassword()));

            boolean exito = ConnectionDB.Update(adm);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Administrador actualizado correctamente.");
                    currentFrame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }

    public static void searchAdminById(int id, JTextField nickField, Consumer<Admin> admSetter) {
        new Thread(() -> {
            Admin adm = ConnectionDB.Select(id);

            SwingUtilities.invokeLater(() -> {
                if (adm != null) {
                    nickField.setText(adm.getNick());
                    admSetter.accept(adm);
                } else {
                    JOptionPane.showMessageDialog(null, "Administrador no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }

    public static void deleteAdmin(Admin adm, Runnable onSuccess, Runnable onFailure, Runnable onFinish) {
        new Thread(() -> {
            boolean exito = ConnectionDB.Delete(adm.getId());

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    onSuccess.run();
                } else {
                    onFailure.run();
                }
                onFinish.run(); // opcional para cerrar ventana o limpiar
            });
        }).start();
    }

    public static void insertAdmin(String nick, String password, Runnable onSuccess, Runnable onFailure, Runnable onFinish) {
        new Thread(() -> {
            Admin adm = new Admin(nick, password);
            boolean exito = ConnectionDB.Insert(adm);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    onSuccess.run();
                } else {
                    onFailure.run();
                }
                onFinish.run(); // opcional
            });
        }).start();
    }
    
    public static void insertPlace(String postalCode, String city, String state, String country, Runnable onSuccess, Runnable onFailure, Runnable onFinish) {
        new Thread(() -> {
            Place place = new Place(postalCode, city, state, country);
            boolean exito = ConnectionDB.Insert(place);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    onSuccess.run();
                } else {
                    onFailure.run();
                }
                onFinish.run(); // opcional
            });
        }).start();
    }

    public static void selectPlace(String postalCode, Consumer<Place> onFound, Runnable onNotFound) {
        new Thread(() -> {
            Place place = ConnectionDB.Select(postalCode);

            SwingUtilities.invokeLater(() -> {
                if (place != null) {
                    onFound.accept(place);
                } else {
                    onNotFound.run();
                }
            });
        }).start();
    }
    
    public static void updatePlace(Place place, String newCity, String newState, String newCountry, Runnable onSuccess, Runnable onFailure, Runnable onFinish) {
        new Thread(() -> {
            place.setCity(newCity);
            place.setStateProvince(newState);
            place.setCountry(newCountry);

            boolean exito = ConnectionDB.Update(place);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    onSuccess.run();
                } else {
                    onFailure.run();
                }
                onFinish.run(); // opcional
            });
        }).start();
    }
    
    public static void insertRace(JFrame frame, JTextField lapsField, JTextField dayField,
                              JTextField monthField, JTextField yearField,
                              JComboBox<String> trackCombo, JTable usersTable) {

        new Thread(() -> {
            try {
                int laps = Integer.parseInt(lapsField.getText().trim());
                int day = Integer.parseInt(dayField.getText().trim());
                int month = Integer.parseInt(monthField.getText().trim());
                int year = Integer.parseInt(yearField.getText().trim());

                
                LocalDate localDate = LocalDate.of(year, month, day);
                Date sqlDate = Date.valueOf(localDate);

                String seleccionado = (String) trackCombo.getSelectedItem();
                int idTrack = Integer.parseInt(seleccionado.split(" - ")[0]);

                DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
                if (model.getRowCount() == 0) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "Debe haber al menos un usuario en la tabla.");
                    });
                    return;
                }

                List<User> usuarios;
                usuarios = new ArrayList<>();

                for (int i = 0; i < model.getRowCount(); i++) {
                    int id = Integer.parseInt(model.getValueAt(i, 0).toString());
                    int position = Integer.parseInt(model.getValueAt(i, 2).toString());

                    usuarios.add(new User(id, position));
                }

                ConnectionDB.Insert(laps, (java.sql.Date) sqlDate, idTrack, usuarios);

                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Carrera insertada con éxito.");
                    frame.setVisible(false);
                });

            } catch (NumberFormatException ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos.");
                });
            }  catch (Exception ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                });
                ex.printStackTrace();
            }
        }).start();
    }
    
    public static void loadRaceData(int id, JTextField lapsField, JTextField dayField,
                                    JTextField monthField, JTextField yearField,
                                    JComboBox<String> trackCombo) {
        new Thread(() -> {
            Race race = ConnectionDB.Select(id, true);

            SwingUtilities.invokeLater(() -> {
                if (race != null) {
                    lapsField.setText(String.valueOf(race.getLapAmount()));

                    java.util.Date utilDate = race.getDate();
                    LocalDate localDate = utilDate.toInstant()
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDate();

                    dayField.setText(String.valueOf(localDate.getDayOfMonth()));
                    monthField.setText(String.valueOf(localDate.getMonthValue()));
                    yearField.setText(String.valueOf(localDate.getYear()));

                    int idTrack = race.getIDTRACK();

                    for (int i = 0; i < trackCombo.getItemCount(); i++) {
                        String item = trackCombo.getItemAt(i);
                        if (item.startsWith(idTrack + " -")) {
                            trackCombo.setSelectedIndex(i);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró una carrera con ese ID.");
                }
            });
        }).start();
    }
    
    public static void updateRace(int id, int laps, int day, int month, int year, 
                                  String selectedTrack, Runnable onSuccess, Runnable onError) {
        new Thread(() -> {
            try {
                LocalDate localDate = LocalDate.of(year, month, day);
                Date date = Date.valueOf(localDate);

                int trackId = Integer.parseInt(selectedTrack.split(" -")[0]);

                Race updatedRace = new Race(id, laps, date, trackId);
                boolean success = ConnectionDB.Update(updatedRace);

                SwingUtilities.invokeLater(() -> {
                    if (success) {
                        if (onSuccess != null) onSuccess.run();
                    } else {
                        if (onError != null) onError.run();
                    }
                });

            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> {
                    if (onError != null) onError.run();
                });
                e.printStackTrace();
            }
        }).start();
    }
    
    public static void insertTrack(JTextField nameField, JTextField descriptionField, JComboBox<String> codeCombo, JFrame frame) {
        new Thread(() -> {
            Track track = new Track(nameField.getText(), descriptionField.getText(), (String) codeCombo.getSelectedItem());
            boolean exito = ConnectionDB.Insert(track);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Pista insertada correctamente.");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al insertar la pista.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }

    public static void loadTrackData(int id, JTextField nameField, JTextField descriptionField,
                                     JComboBox<String> codeCombo, Consumer<Track> setTrack) {
        new Thread(() -> {
            Track track = ConnectionDB.Select(id, 0);

            SwingUtilities.invokeLater(() -> {
                if (track != null) {
                    nameField.setText(track.getName());
                    descriptionField.setText(track.getDescription());
                    codeCombo.setSelectedItem(track.getPostalCode());
                    setTrack.accept(track);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un registro con ese ID.");
                }
            });
        }).start();
    }
    
     public static void updateTrack(Track track, int id, JFrame frame) {
        new Thread(() -> {
            boolean exito = ConnectionDB.Update(track, id);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }
     
    public static void insertUser(JTextField nameField, JTextField vehicleField, JFrame frame) {
        new Thread(() -> {
            User user = new User(nameField.getText(), vehicleField.getText());
            boolean exito = ConnectionDB.Insert(user);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }
    
    public static void loadUserById(int id, JTextField nameField, JTextField vehicleField, Consumer<User> setUser) {
        new Thread(() -> {
            User user = ConnectionDB.Select(id, "dummy");

            SwingUtilities.invokeLater(() -> {
                if (user != null) {
                    nameField.setText(user.getNick());
                    vehicleField.setText(user.getVehicle());
                    setUser.accept(user);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese ID.");
                }
            });
        }).start();
    }
    
    public static void updateUser(User user, int id, JFrame frame, JTextField nameField, JTextField vehicleField) {
        new Thread(() -> {
            user.setNick(nameField.getText());
            user.setVehicle(vehicleField.getText());

            boolean exito = ConnectionDB.Update(user, id);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }).start();
    }
}

