package caldas;

public class FabricaDasCaldas {

    public static void main(String[] args) {

        TrabalhadorDasCaldas gerente = new TrabalhadorDasCaldas("Jorge", 0);
        TrabalhadorDasCaldas trab1 = new TrabalhadorDasCaldas("Vanessa", 10);
        TrabalhadorDasCaldas trab2 = new TrabalhadorDasCaldas("Valete", 10);
        TrabalhadorDasCaldas trab3 = new TrabalhadorDasCaldas("Horácio", 10);

        Thread threadTrab1 = new Thread(trab1);
        Thread threadTrab2 = new Thread(trab2);
        Thread threadTrab3 = new Thread(trab3);

        System.out.println(gerente.getName() + ": Mais um dia de trabalho, start!");
        threadTrab1.start();
        threadTrab2.start();
        threadTrab3.start();

        try {
            threadTrab1.join();
            threadTrab2.join();
            threadTrab3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(gerente.getName() + ": Finalmente! Vou pra casa. ");


    }




}
