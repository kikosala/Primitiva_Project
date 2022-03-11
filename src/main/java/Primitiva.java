public class Primitiva {

    public enum Categoria{
        PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA, REINTEGRO, ESPECIAL
    }

    private Boleto boletoGanador;

    public Primitiva() {
        boletoGanador = new Boleto();
    }

    public Categoria jugar(Boleto boleto){

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
            default: if(boleto.getReintegro() == boletoGanador.getReintegro()){
                return Categoria.REINTEGRO;
            }
        }
        return null;

    }

    public Boleto getBoletoGanador() {
        return boletoGanador;
    }

    public Categoria jugarHastaPremio() {
        Categoria categoria = null;
        while(categoria == null){
            categoria = jugar(new Boleto());
        }
        return categoria;
    }
    public Categoria jugarHastaPremioSinReintegro() {
        Categoria categoria = null;
        while(categoria == null || categoria.equals(Categoria.REINTEGRO)){
            categoria = jugar(new Boleto());
        }
        return categoria;
    }

    public int[] cicloDe10000Sorteos() {
        final int limite = 10000;
        int[] resultado = new int[Categoria.values().length];

        Categoria categoria = null;

        for(int i = 0; i < limite; i++){
            categoria = jugar(new Boleto());
            if (categoria != null) {
                switch (categoria) {
                    case PRIMERA -> resultado[0] += 1;
                    case SEGUNDA -> resultado[1] += 1;
                    case TERCERA -> resultado[2] += 1;
                    case CUARTA -> resultado[3] += 1;
                    case QUINTA -> resultado[4] += 1;
                    case REINTEGRO -> resultado[5] += 1;
                    case ESPECIAL -> resultado[6] += 1;
                }
            }
        }
        return resultado;
    }

    public long jugarHastaCategoriaEspecial() {
        long intentos = 0;
        Categoria categoria = null;

        while(categoria != Categoria.ESPECIAL){
            intentos++;
            categoria = jugar(new Boleto());
        }
        return intentos;
    }

}
