public class Cadet implements Runnable{

    private String name;

    private Bathroom wc;

    public Cadet(String name, Bathroom wc) {
        this.name = name;
        this.wc = wc;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        wc.enter();
        wc.washHands();
    }
}
