package libs;

public class Vectors{

    /**
     * Metodo que rellena un array con nums aleatorios
     * @param a Array a rellenar
     * @param min Minimo elemento posible en cada posicion
     * @param max Maximo elemento posible en cada posicion
     */
    public static void rellenarArrayRandom(int[]a, int min, int max){
        for(int i = 0; i < a.length; i++){
            a[i] = Randoms.random(min, max);
        }
    }
    /**
     * Metodo que visualiza los multiplos de un numero en un array
     * @param a Array con el contenido a evaluar
     * @param num numero que usaremos para evaluar sus multiplos
     */
    public static int[] arrayMultiplo(int[]a, int num){
        if(a != null){
            int[]arrayMultiplos;
            int multiplos = 0;
            int aux = 0;
            for(int i = 0; i < a.length; i++){
                if(a[i] % num == 0){
                    multiplos++;
                }
            }
            arrayMultiplos = new int[multiplos];
            for(int i = 0; i < a.length; i++){
                if(a[i] % num == 0){
                    arrayMultiplos[aux] = a[i];
                    aux++;
                }
            }
            return arrayMultiplos;
        }
        return null;
    }
    public static void ordenarArray(int[] array) {
        boolean cambios = true;
        while(cambios) {
            cambios = false;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i+1]) {
                    intercambio(array, i, i + 1);
                    cambios = true;
                }
            }
        }
    }
    public static void intercambio(int[]array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    public static void intercambio(double[]array, int i, int j) {
        double aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    public static <T> void intercambio(T[]array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    public static <T> T[] agrandarArray(T[]array, double growFactor){
        T[] nuevoArray = (T[])new Object[(int)(array.length*growFactor)];
        for(int i = 0; i < array.length; i++){
            nuevoArray[i] = array[i];
        }
        return nuevoArray;
    }
    public static int[] agrandarArray(int array[], double growFactor){
        int[] nuevoArray = new int[(int)(array.length*growFactor)];
        for(int i = 0; i < array.length; i++){
            nuevoArray[i] = array[i];
        }
        return nuevoArray;
    }
    public static double[] agrandarArray(double array[], double growFactor){
        double[] nuevoArray = new double[(int)(array.length*growFactor)];
        for(int i = 0; i < array.length; i++){
            nuevoArray[i] = array[i];
        }
        return nuevoArray;
    }
    public static <T> void anyadirElemento(T[]array, T elemento, int numElementos){
        if(array.length == numElementos){
            array = agrandarArray(array, 1.75);
        }
        array[numElementos] = elemento;
    }
    public static void anyadirElemento(int array[], int elemento, int numElementos){
        if(array.length == numElementos){
            array = agrandarArray(array,1.75);
        }
        array[numElementos] = elemento;
    }
    public static void anyadirElemento(double array[], int elemento, int numElementos){
        if(array.length == numElementos){
            array = agrandarArray(array,1.75);
        }
        array[numElementos] = elemento;
    }
    public static <T> boolean eliminarElemento(T[]array, T elemento, int numElementos){
        boolean exito = false;
        if(numElementos > 0){
            for(int i = 0; i < numElementos; i++){
                if(array[i] != null && array[i].equals(elemento)){
                    intercambio(array, i, numElementos-1);
                    array[numElementos-1] = null;
                    exito = true;
                    break;
                }
            }
        }
        return exito;
    }
    public static boolean eliminarElemento(int[]array, int elemento, int numElementos){
        boolean exito = false;
        if(numElementos > 0){
            for(int i = 0; i < numElementos; i++){
                if(array[i] == elemento){
                    intercambio(array, i, numElementos-1);
                    array[numElementos-1] = 0;
                    exito = true;
                    break;
                }
            }
        }
        return exito;
    }
    public static boolean eliminarElemento(double[]array, double elemento, int numElementos){
        boolean exito = false;
        if(numElementos > 0){
            for(int i = 0; i < numElementos; i++){
                if(array[i] == elemento){
                    intercambio(array, i, numElementos-1);
                    array[numElementos-1] = 0;
                    exito = true;
                    break;
                }
            }
        }
        return exito;
    }
}
