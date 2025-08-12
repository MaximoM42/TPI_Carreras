package Clases;

public class User {
    private int id;
    private String nick;
    private String vehicle;
    private int position;
    
    public User(){}
    
    public User(String newN, String newV){
        this.nick = newN;
        this.vehicle = newV;
    }
    
    public User(int newI, int newP){
        this.id = newI;
        this.position = newP;
    }
    
// GET & SET

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    
}
