import libs.Readers;

import java.util.Scanner;

import static libs.Randoms.random;

public class Main {

    public static Primitiva primitiva = new Primitiva();

    public Main() {

        //DECLARACIÓN DE VARIABLES
        Boleto boletoUsuario = null;
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
                    System.out.println(primitiva.jugar(boletoUsuario));
                    break;
                case 2:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO:");
                    System.out.println(primitiva.jugarHastaPremio());
                    break;
                case 3:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO (SIN REINTEGRO):");
                    primitiva.jugarHastaPremioSinReintegro();
                    break;
                case 4:
                    System.out.println("\n>Has elegido CICLO DE 10000 SORTEOS:");
                    primitiva.cicloDe10000Sorteos();
                    break;
                case 5:
                    System.out.println("\n>Has elegido JUGAR HASTA OBTENER PREMIO CATEGORIA ESPECIAL:");
                    primitiva.jugarHastaCategoriaEspecial();
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

        int[] combi = new int[boleto.getCombinacion().length];
        int numUser, complementario, reintegro;

        for (int i = 0; i < combi.length; i++) {

            numUser = Readers.readInt("\n>Introduzca un numero:");
            boleto.getCombinacion()[i] = numUser;

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
