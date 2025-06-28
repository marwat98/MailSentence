package JavaFXClass;

import java.util.Date;

public class TableEmail {
    private  final int id;
    private final String email;
    private final Date date;

    public TableEmail(String email, int id, Date date){
        this.id = id;
        this.email = email;
        this.date = date;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public Date getDate(){
        return date;
    }
}
