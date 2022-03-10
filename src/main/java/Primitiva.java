public class Primitiva {
    public enum Categoria{
        ESPECIAL, PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA
    }

    private Boleto boletoGanador;

    public Primitiva() {
        boletoGanador = new Boleto();
    }

    public Categoria comproabarCategoria(Boleto boleto){
        int aciertos = 0;
        for(int i = 0; i < boletoGanador.getCombinacion().length; i++){
            for(int j = 0; j < boleto.getCombinacion().length; j++){
                if(boletoGanador.getCombinacion()[i] == boleto.getCombinacion()[j]){
                    aciertos++;
                }
            }
        }
        switch (aciertos){
            case 3: return Categoria.QUINTA;
            case 4: return  Categoria.CUARTA;
            case 5:
                if(boleto.getComplementario() == boletoGanador.getComplementario()){
                    return Categoria.SEGUNDA;
                }else{
                    return Categoria.TERCERA;
                }
            case 6:
                if(boleto.getReintegro() == boletoGanador.getReintegro()){
                    return Categoria.ESPECIAL;
                }else{
                    return Categoria.PRIMERA;
                }
            default: return null;
        }
    }

    public Boleto getBoletoGanador() {
        return boletoGanador;
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
