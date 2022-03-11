import libs.Readers;

import java.util.Arrays;
import java.util.Scanner;

import static libs.Randoms.random;

public class Main {

    public static Primitiva primitiva = new Primitiva();

    public static void main(String args[]) {

        //DECLARACIÓN DE VARIABLES
        Boleto boletoUsuario = null;
        int option = 0;

        //IMPRIMIMOS EL PROGRAMA
        System.out.println(">JUEGO DE PRIMITIVA");

        //ELECCION DE NUMEROS
        do {
            /*Imprimimos el menu y devolvemos la opcion elegida*/
            option = menu("\nPRIMITIVA:" + "\n-" +  "\nElija sus numeros" + "\n1.- MANUALMENTE" +
                    "\n2.- ALEATORIAMENTE" + "\n0.- SALIR DEL MENU" + "\n-" + "\nSelecciona una opción [0-2]");

            /*Switcheamos la opcion y ejecutará el metodo indicado*/
            switch (option) {
                default:
                    System.out.print("\n> **POR FAVOR, INTRODUZCA UNA DE LAS OPCIONES INDICADAS**" +
                            "\n> [" + option + "] no es apropiado.\n");
                    break;
                case 1:
                    System.out.println("\n>Has elegido MANUALMENTE.");
                    boletoUsuario = combinacionManual();
                    System.out.println("\n>Su combinacion es: " + boletoUsuario);
                    break;
                case 2:
                    System.out.println("\n>Has elegido ALEATORIAMENTE:");
                    boletoUsuario = new Boleto();
                    System.out.println("\n>Su combinacion es: " + boletoUsuario);
                    break;
                case 0:
                    System.out.println("\n¡Hasta la proxima!");
                    break;
            }

        } while (!exitMenu(option));

        //ELECCION DE JUEGOS
        option = 0;
        do {

            /*Imprimimos el menu y devolvemos la opcion elegida*/
            option = menu("\nPRIMITIVA:" + "\n-" + "\n1.- JUEGO UNICO" +
                    "\n2.- JUGAR HASTA OBTENER PREMIO" + "\n3.- JUGAR HASTA OBTENER PREMIO (SIN REINTEGRO)" +
                    "\n4.- CICLO DE 10000 SORTEOS" + "\n5.- JUGAR HASTA OBTENER PREMIO CATEGORIA ESPECIAL" +
                    "\n0.- SALIR DEL MENU" + "\n-" + "\nSelecciona una opción [0-4]");

            /*Switcheamos la opcion y ejecutará el metodo indicado*/
            switch (option) {
                default:
                    System.out.print("\n> **POR FAVOR, INTRODUZCA UNA DE LAS OPCIONES INDICADAS**" +
                            "\n> [" + option + "] no es apropiado.\n");
                    break;
                case 1:
                    System.out.println("\n>Has elegido JUEGO UNICO.");

                    if (primitiva.jugar(boletoUsuario) == null)
                        System.out.println(">No te ha tocado!!!");
                    else
                        System.out.println(">Te ha tocado " + primitiva.jugar(boletoUsuario));

                    break;
                case 2:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO:");
                    System.out.println(">Te ha tocado " + primitiva.jugarHastaPremio());
                    break;
                case 3:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO (SIN REINTEGRO):");
                    System.out.println(">Te ha tocado " + primitiva.jugarHastaPremioSinReintegro());
                    break;
                case 4:
                    System.out.println("\n>Has elegido CICLO DE 10000 SORTEOS:");
                    System.out.println(">PRIMERA \t>SEGUNDA \t>TERCERA \t>CUARTA \t>QUINTA \t>REINTEGRO \t>ESPECIAL");
                    System.out.println(Arrays.toString(primitiva.cicloDe10000Sorteos()));
                    break;
                case 5:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO CATEGORIA ESPECIAL:");

                    System.out.println("\n>Boleto ganador:");
                    System.out.println(primitiva.getBoletoGanador().toString());
                    System.out.println("\n>Intentos hasta conseguir la categoria especial:");
                    System.out.println(primitiva.jugarHastaCategoriaEspecial());
                    break;
                case 0:
                    System.out.println("\n¡Hasta la proxima!");
                    break;
            }

        } while (!exitMenu(option));

    }

    /**
     * combinacionManual()
     * Devuelve una combinacion elegida por el usuario.
     * @return
     */
    public static Boleto combinacionManual() {

        Boleto boleto = null;

        int[] combi = new int[6];
        int numUser, complementario;

        for (int i = 0; i < combi.length; i++) {

            numUser = Readers.readInt("\n>Introduzca un numero:");
            combi[i] = numUser;

        }

        //Complementario
        complementario = Readers.readInt("\n>Introduzca un numero:");

        //El reintegro se creara en el constructor
        boleto = new Boleto(combi, complementario);

        return boleto;

    }

    /**
     * menu()
     * Imprime el menu y devuelve la opcion
     * @return
     */
    public static int menu(String texto) {


        return Readers.readInt(texto);
    }

    /**
     * exitMenu()
     * Validacion del bucle del menú.
     * @param option
     * @return
     */
    public static boolean exitMenu(int option) {

        if (option != 0)
            return false;
        return true;

    }

}
