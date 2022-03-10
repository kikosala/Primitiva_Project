package libs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Readers {
    private final static Scanner lector = new Scanner(System.in);
    public static int readInt(String message){
        boolean isValid = false;
        int data = 0;
        do{
            try{
                System.out.println(message);
                data = Integer.parseInt(lector.nextLine());
                isValid = true;
            }catch (NumberFormatException nfe){
                System.out.println("Solo numeros por favor");
            }
        }while(!isValid);
        return data;
    }
    public static double readDouble(String message){
        boolean isValid = false;
        double data = 0;
        do{
            try{
                System.out.println(message);
                data = Double.parseDouble(lector.nextLine());
                isValid = true;
            }catch (NumberFormatException nfe){
                System.out.println("Solo numeros por favor");
            }
        }while(!isValid);
        return data;
    }
    public static String readString(){
        String s = "";
        s = lector.nextLine();
        return s;
    }
    public static char readChar(){
        char c = ' ';
        c = lector.nextLine().charAt(0);
        return c;
    }
}
