import libs.Readers;

import java.util.Scanner;

import static libs.Randoms.random;

public class Main {

    public static Primitiva primitiva = new Primitiva();

    public Main() {

        //DECLARACIÓN DE VARIABLES
        String combinacionUsuario = "";
        int option = 0;

        //IMPRIMIMOS EL PROGRAMA
        System.out.println(">");

        //ELECCION DE NUMEROS
        do {
            /*Imprimimos el menu y devolvemos la opcion elegida*/
            option = menu("\nPRIMITIVA:" + "\n-" +  "\nElija sus numeros" + "\n1.- MANUALMENTE" +
                    "\n2.- ALEATORIAMENTE" + "\n-" + "\nSelecciona una opción [0-2]");

            /*Switcheamos la opcion y ejecutará el metodo indicado*/
            switch (option) {
                default:
                    System.out.print("\n> **POR FAVOR, INTRODUZCA UNA DE LAS OPCIONES INDICADAS**" +
                            "\n> [" + option + "] no es apropiado.\n");
                    break;
                case 1:
                    System.out.println("\n>Has elegido MANUALMENTE.");
                    combinacionUsuario = combinacionManual();
                    System.out.println("\n>Su combinacion es: " + combinacionUsuario);
                    break;
                case 2:
                    System.out.println("\n>Has elegido ALEATORIAMENTE:");
                    combinacionUsuario = primitiva.getCombinacionGanadora();
                    System.out.println("\n>Su combinacion es: " + combinacionUsuario);
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
                    primitiva.
                    break;
                case 2:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO:");
                    break;
                case 3:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO (SIN REINTEGRO):");
                    break;
                case 4:
                    System.out.println("\n>Has elegido CICLO DE 10000 SORTEOS:");
                    break;
                case 5:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO CATEGORIA ESPECIAL:");
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
    public static String combinacionManual() {

        String combinacionUsuario = "";

        for (int i = 0; i < 6; i++) {

            combinacionUsuario += String.valueOf(Readers.readInt("\n>Introduzca un numero: "));
        }

        return combinacionUsuario += String.valueOf(random(0, 9));

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
