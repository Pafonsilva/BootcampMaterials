package caldas;

public class TrabalhadorDasCaldas implements Runnable{

    private String name;
    private int productionTarget;

    public TrabalhadorDasCaldas(String name, int productionTarget) {
        this.name = name;
        this.productionTarget = productionTarget;
    }

    public String getName() {
        return name;
    }

    public void makeAPorcelain() {
        System.out.println(getName() + "-> Estou aqui a fazer umas loiças...");
        productionTarget--;
    }

    @Override
    public void run() {
       while(productionTarget > 0) {

           makeAPorcelain();
           try {
               Thread.sleep(2000);

           } catch (InterruptedException e) {
               System.out.println("Estava a 'trabalhar', e acordaram-me!");
               e.printStackTrace();
           }

       }
        System.out.println(getName() + " Não faço nem mais um caralho.");

    }
}
