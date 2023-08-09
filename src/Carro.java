import java.util.Random;

public class Carro implements Mecanica{
    private String cor;
    private String marca;
    private String tp_pneu;
    private boolean andando;
    private boolean ligado;
    private float vel_max;
    private float vel_atual;
    private float pot;
    private Piloto dados;

    public Carro(String cor, String marca, String tp_pneu, Piloto dados, float vel_max, float pot) {
        this.cor = cor;
        this.marca = marca;
        this.tp_pneu = tp_pneu;
        this.dados = dados;
        this.vel_max = vel_max;
        this.pot = pot;
        this.andando = false;
        this.ligado = false;
        this.vel_atual = 0.0f;
    }
    public void apresentar(Piloto x) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                     Dados do Piloto                     ║");
        System.out.println("╟─────────────────────────────────────────────────────────╢");
        System.out.println("║ Nome          | " + x.getNome());
        System.out.println("║ Idade         | " + x.getIdade());
        System.out.println("║ Nacionalidade | " + x.getNacionalidade());
        System.out.println("╚═══════════════════════════════════════════════════════╝");

        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║               Características do Carro                 ║");
        System.out.println("╟─────────────────────────────────────────────────────────╢");
        System.out.println("║ Cor         | " + cor);
        System.out.println("║ Marca       | " + marca);
        System.out.println("║ Tipo Pneu   | " + tp_pneu);
        System.out.println("║ Veloc. Máx. | " + vel_max + " km/h");
        System.out.println("║ Potência    | " + pot + " CV");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTp_pneu() {
        return tp_pneu;
    }

    public void setTp_pneu(String tp_pneu) {
        this.tp_pneu = tp_pneu;
    }

    public boolean isAndando() {
        return andando;
    }

    public void setAndando(boolean andando) {
        this.andando = andando;
    }

    public Piloto getDados() {
        return dados;
    }

    public void setDados(Piloto dados) {
        this.dados = dados;
    }

    public float getVel_max() {
        return vel_max;
    }

    public void setVel_max(float vel_max) {
        this.vel_max = vel_max;
    }

    public float getPot() {
        return pot;
    }

    public void setPot(float pot) {
        this.pot = pot;
    }

    public float getVel_atual() {
        return vel_atual;
    }

    public void setVel_atual(float vel_atual) {
        this.vel_atual = vel_atual;
    }

    @Override
    public void ligar() {
        if(!(ligado)) {
            ligado = true;
        } else {
            System.out.println("O carro já esta ligado!");
        }
    }

    @Override
    public void desligar() {
        if(ligado) {
            ligado = false;
        } else {
            System.out.println("O carro já esta desligado!");
        }
    }

    @Override
    public void acelerar() {
        andando = true;
        Random nvlVel = new Random();
        int nvVel = nvlVel.nextInt(10);

        float medicao = pot / 100;
        int aceleracao = (int) (medicao * 5);

       if(ligado) {
           for(int i = 0; i < nvVel; i++) {
               vel_atual += aceleracao;
           }
           if(vel_atual >= vel_max) {
               vel_atual = vel_max;
           }
       } else {
           System.out.println("Impossivel acelerar com o carro desligado");
       }
    }
    @Override
    public void frear() {
        Random freio = new Random();
        int fr = freio.nextInt(3);

        if(ligado) {
            if(andando) {
                if(vel_atual != 0) {
                    switch (fr) {
                        //não freiou o carro
                        case 0:
                            System.out.println("O piloto " + dados.getNome() + " foi astuto, não precisou frear!!");
                            break;
                        case 1:
                            for (int i = 0; i < fr; i++) {
                                vel_atual -= 12;
                            }
                            break;
                        case 2:
                            for (int i = 0; i < fr; i++) {
                                vel_atual -= 15;
                            }
                    }
                } else {
                    System.out.println("O carro não esta em movimento");
                }
            } else {
                System.out.println("carro parado, não existe a possibilidade de frear");
            }
        } else {
            System.out.println("carro desligado, não existe a possibilidade de frear");
        }
    }

}
