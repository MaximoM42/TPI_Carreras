package Clases;

public class Admin {
    private int id;
    private String nick;
    private String password;

    public Admin(){}
    
    public Admin(String newN, String newP){
        this.nick = newN;
        this.password = newP;
    }
    
    public Admin(int newI, String newN, String newP){
        this.id = newI;
        this.nick = newN;
        this.password = newP;
    }
// GET & SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
