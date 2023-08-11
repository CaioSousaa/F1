import java.util.Random;

//versão com volta unica
public class Corrida {
    private Carro corredor1;
    private Carro corredor2;

    private boolean aprovar;
    int taxa_vitoriapl1;
    int taxa_vitoriapl2;

    public Corrida(){
        this.taxa_vitoriapl1 = 50;
        this.taxa_vitoriapl2 = 50;
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

   Random sorte = new Random();
   int tpPista = sorte.nextInt(2);

    public void taxaVitoria(Carro corredor1, Carro corredor2){
        if(corredor1.getTp_pneu().equals("NM") && tpPista == 0) {
            taxa_vitoriapl1 += 20;
        } else if(corredor1.getTp_pneu().equals("PM") && tpPista == 1) {
            taxa_vitoriapl1 += 20;
        } else if(corredor1.getTp_pneu().equals("NM") && tpPista == 1) {
            taxa_vitoriapl1 -= 20;
        } else if(corredor1.getTp_pneu().equals("PM") && tpPista == 0) {
            taxa_vitoriapl1 -= 20;
        }
        if(corredor2.getTp_pneu().equals("NM") && tpPista == 0) {
            taxa_vitoriapl2 += 20;
        } else if(corredor2.getTp_pneu().equals("PM") && tpPista == 1) {
            taxa_vitoriapl2 += 20;
        } else if(corredor2.getTp_pneu().equals("NM") && tpPista == 1) {
            taxa_vitoriapl2 -= 20;
        } else if(corredor2.getTp_pneu().equals("PM") && tpPista == 0) {
            taxa_vitoriapl2 -= 20;
        }

        if(corredor1.getVel_atual() > corredor2.getVel_atual()) {
            taxa_vitoriapl1 += 15;
        } else if(corredor1.getVel_atual() < corredor2.getVel_atual()){
            taxa_vitoriapl2 += 15;
        } else {
            taxa_vitoriapl2 += 10;
            taxa_vitoriapl1 += 10;
        }

        if(corredor1.getVel_atual() >= (corredor1.getVel_max() * 80)/100) {
           taxa_vitoriapl1 += 25;
        } else if(corredor1.getVel_atual() >= (corredor1.getVel_max() * 50)/100) {
            taxa_vitoriapl1 += 15;
        } else {
            taxa_vitoriapl1 += 10;
        }

        if(corredor2.getVel_atual() >= (corredor2.getVel_max() * 80)/100) {
            taxa_vitoriapl2 += 25;
        } else if(corredor2.getVel_atual() >= (corredor2.getVel_max() * 50)/100) {
            taxa_vitoriapl2 += 15;
        } else {
            taxa_vitoriapl2 += 10;
        }

    }

    public void corrida(Carro corredor1, Carro corredor2, Piloto pl1, Piloto pl2){
        if(taxa_vitoriapl1 > taxa_vitoriapl2) {
            System.out.println("E O CAMPEÃO FOI O !!" + pl1.getNome());
            corredor1.apresentar(pl1);
        } else if(taxa_vitoriapl1 < taxa_vitoriapl2) {
            System.out.println("E O CAMPEÃO FOI O !!" + pl2.getNome());
            corredor2.apresentar(pl2);
        } else {
            System.out.println("Ouve um empate!!");
        }
    }

}
