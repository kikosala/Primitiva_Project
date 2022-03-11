import libs.Bombo;

import java.util.Arrays;

public class Boleto {

    private  final int lengthCombinacion = 6;
    private static final int MIN_BOLA_GRANDE = 1, MIN_BOLA_PEQUENYO = 0;
    private static final int MAX_BOLA_GRANDE = 49, MAX_BOLA_PEQUENYO = 9;

    private static Bombo bomboGrande = new Bombo(MAX_BOLA_GRANDE, MIN_BOLA_GRANDE);
    private static Bombo bomboPequenyo = new Bombo(MAX_BOLA_PEQUENYO, MIN_BOLA_PEQUENYO);

    private int combinacion[];
    private int complementario;
    private int reintegro;

    public Boleto(int[] combinacion, int complementario) {

        this.combinacion = combinacion;
        this.complementario = complementario;
        reintegro = bomboPequenyo.extraerBola();
        bomboPequenyo.reset();

    }

    public Boleto(){

        combinacion = generarCombinacion();
        complementario = bomboGrande.extraerBola();
        reintegro = bomboPequenyo.extraerBola();
        bomboPequenyo.reset();
        bomboGrande.reset();

    }

    public int[] generarCombinacion(){

        int combinacion[] = new int [lengthCombinacion];

        for(int i = 0; i < combinacion.length; i++){
            combinacion[i] = bomboGrande.extraerBola();
        }

        return combinacion;

    }

    //Getters
    public int getLengthCombinacion() {
        return lengthCombinacion;
    }

    public int[] getCombinacion() {
        return combinacion;
    }

    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "combinacion=" + Arrays.toString(combinacion) +
                ", complementario=" + complementario +
                ", reintegro=" + reintegro +
                '}';
    }

}
