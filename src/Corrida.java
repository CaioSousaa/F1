import java.util.Random;

//versão com volta unica
public class Corrida {
    private Carro corredor1;
    private Carro corredor2;
    private boolean aprovar;
    int taxa_vitoria;
    
    public Corrida(){
        this.taxa_vitoria = 0;
        this.aprovar = false;
    }

    public Carro getCorredor1() {
        return corredor1;
    }

    public void setCorredor1(Carro corredor1) {
        this.corredor1 = corredor1;
    }

    public Carro getCorredor2() {
        return corredor2;
    }

    public void setCorredor2(Carro corredor2) {
        this.corredor2 = corredor2;
    }

    public boolean isAprovar() {
        return aprovar;
    }

    public void setAprovar(boolean aprovar) {
        this.aprovar = aprovar;
    }

    Random tp_pista = new Random();
    int p = tp_pista.nextInt(2);
    //0 = pista molhada (PM) ### 1 = pista normal (NM)
    Random sorte = new Random();
    int acrescimo = sorte.nextInt(5);
    //0 ---> 5p ### 1 --> 7p ### 2 --> 10p ### 3 --> 12p ### 4 --> 18p

    public void aprovarCorrida(Piloto pl1, Piloto pl2 ){
        if(pl1 != pl2) {
            aprovar = true;
        } else {
            System.out.println("A corrida não pode acontecer");
        }
    }

}
