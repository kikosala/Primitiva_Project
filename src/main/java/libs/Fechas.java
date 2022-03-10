package libs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fechas {
    public static String formatDate(GregorianCalendar fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha.getTime());
    }
    public static String formatHour(GregorianCalendar fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(fecha.getTime());
    }
    public static GregorianCalendar validarFecha(String fechaString, String formato){
        boolean validado = false;
        GregorianCalendar fecha = new GregorianCalendar();
        do{
            try {
                fecha.setTime(new SimpleDateFormat(formato).parse(fechaString));
                validado = true;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Por favor, introduce una fecha valida " + formato);
            }
        }while(!validado);
        return fecha;
    }
    public static int getAnyos(GregorianCalendar fechaIni){
        int anyoInicial = fechaIni.get(Calendar.YEAR);
        int mesInicial = fechaIni.get(Calendar.MONTH)+1;
        int diaInicial = fechaIni.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH);
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad = anyoActual - anyoInicial;
        if(mesActual < mesInicial){
            edad--;
        }else if(mesActual == mesInicial){
            if(diaActual < diaInicial){
                edad--;
            }
        }
        return edad;
    }
}
