import libs.Bombo;

public class Primitiva {
    public enum Categoria{
        ESPECIAL, PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA
    }
    private static final int MIN_BOLA_GRANDE = 1, MIN_BOLA_PEQUENYO = 0;
    private static final int MAX_BOLA_GRANDE = 49, MAX_BOLA_PEQUENYO = 9;
    private static final int lengthCombinacion = 7;
    private Bombo bomboGrande;
    private Bombo bomboPequeño;
    private String combinacionGanadora;

    public Primitiva() {
        bomboGrande = new Bombo(MAX_BOLA_GRANDE, MIN_BOLA_GRANDE);
        bomboPequeño = new Bombo(MAX_BOLA_PEQUENYO, MIN_BOLA_PEQUENYO);
        combinacionGanadora = generarCombinacion();
    }
    public String generarCombinacion(){
        StringBuilder combinacion = new StringBuilder();
        for(int i = 0; i < lengthCombinacion-1; i++){
            combinacion.append(bomboGrande.extraerBola());
        }
        combinacion.append(bomboPequeño.extraerBola());
        return combinacion.toString();
    }

    public String getCombinacionGanadora() {
        return combinacionGanadora;
    }

    public String jugarUnico() {
        return null;
    }

    public String jugarHastaPremio() {
        return null;
    }

    public String jugarHastaPremioSinReintegro() {
        return null;
    }

    public String cicloDe10000Sorteos() {
        return null;
    }

    public String jugarHastaCategoriaEspecial() {
        return null;
    }

}
