package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHandler {
    private GregorianCalendar gc;
    private Date dataConvertida;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh");

    public void setDataHR(String data){
        try {
            this.gc = new GregorianCalendar();
            this.gc.setTime(formatter.parse(data));
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    public Date getDate(){
        dataConvertida = gc.getTime();
        return dataConvertida;
    }

    public static String dateToString(Date dataParaString){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh");
        String dataString = formatter.format(dataParaString);
        return dataString;
    }

    /**
     * checa se a data de inicio eh anterior a data final
     * @param inicio
     * @param fim
     * @return
     */
    public boolean checkDate(Date inicio, Date fim){
        this.gc.setTime(inicio);
        return this.gc.before(fim);
    }

    /**
     * soma o periodo com a data de inicio e retorna data
     * @param inicio
     * @param periodo
     * @return
     */
    public String somaPeriodo(Date inicio, int periodo){
        this.gc.setTime(inicio);
        this.gc.add(5, periodo);
        Date dataEncerramentoDaBolsa = this.gc.getTime();
        
        return formatter.format(dataEncerramentoDaBolsa);
    }
}
