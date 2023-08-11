public class Acesso {
    public static void main(String[] args) {
        Carro car[] = new Carro[2];
        Piloto pl[] = new Piloto[2];
        Corrida c1 = new Corrida();
        pl[0] = new Piloto("Caio", 19, "Brasileiro", "M", 35,0);
        car[0] = new Carro("Preta", "Gol-Bolinha","NM", pl[0], 360.0f,800.0f);
        //car[0].apresentar(pl[0]);
        car[0].ligar();
        car[0].acelerar();
        car[0].frear();

        pl[1] = new Piloto("Maria", 18, "Brasileira", "F", 15,20);

        car[1] = new Carro("Branco", "Ferrari","PM", pl[1], 480.0f,1600.0f);

        car[1].ligar();
        car[1].acelerar();
        car[1].frear();

        c1.taxaVitoria(car[0], car[1]);
        c1.corrida(car[0], car[1], pl[0], pl[1]);
    }
}
