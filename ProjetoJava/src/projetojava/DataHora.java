package projetojava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** Busca a data e hora do sistema */
public class DataHora {
    
    public String getDataTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss"); 
        Date date = new Date(); 
        return dateFormat.format(new Date());
 
    }
}
