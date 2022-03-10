import java.util.Scanner;

public class Main {

    public Main() {

        //DECLARACIÓN DE VARIABLES
        int option = 0;

        //IMPRIMIMOS EL PROGRAMA
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
     * menu()
     * Imprime el menu y devuelve la opcion
     * @return
     */
    public static int menu(String texto) {

        System.out.println(texto);
        return readInt();

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

    /**
     * Lee y devuelve un int
     * @return
     */
    public static int readInt() {
        Scanner lector = new Scanner(System.in);
        return Integer.parseInt(lector.nextLine());
    }

}
