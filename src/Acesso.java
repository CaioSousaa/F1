public class Acesso {
    public static void main(String[] args) {
        Carro car[] = new Carro[2];
        Piloto pl[] = new Piloto[2];

        pl[0] = new Piloto("Caio", 19, "Brasileiro", "M", 35,0);

        car[0] = new Carro("Preta", "Gol-Bolinha","NM", pl[0], 360.0f,800.0f);
        //car[0].apresentar(pl[0]);
        car[0].ligar();
        car[0].acelerar();
        System.out.println(car[0].getVel_atual());
        car[0].frear();
        System.out.println(car[0].getVel_atual());

    }
}
