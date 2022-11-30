package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHandler {
    private GregorianCalendar gc;
    private Date paraManipular;
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
        paraManipular = gc.getTime();
        return paraManipular;
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
     * checa se o periodo ultrapassa a data final
     * @param inicio
     * @param fim
     * @param periodo
     * @return
     */
    public boolean checkPeriod(Date inicio, Date fim, int periodo){
        this.gc.setTime(inicio);
        this.gc.add(0, periodo);
        return this.gc.after(fim);
    }
}
