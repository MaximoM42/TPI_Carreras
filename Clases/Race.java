package Clases;
import java.util.Date;

public class Race {
    private int id;
    private int lapAmount;
    private Date date;
    private int IDTRACK;
    
    public Race(){}
    
    public Race(int newL, Date newD, int newI){
        this.lapAmount = newL;
        this.date = newD;
        this.IDTRACK = newI;
    }
    public Race(int newI, int newL, Date newD, int newIT){
        this.id = newI;
        this.lapAmount = newL;
        this.date = newD;
        this.IDTRACK = newI;
    }
    
// GET & SET

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getLapAmount() {
        return lapAmount;
    }

    public void setLapAmount(int lapAmount) {
        this.lapAmount = lapAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIDTRACK() {
        return IDTRACK;
    }

    public void setIDTRACK(int IDTRACK) {
        this.IDTRACK = IDTRACK;
    }
}
