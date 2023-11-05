public class Bathroom {

    private Toilet toilet;

    public Bathroom(Toilet toilet) {
        this.toilet = toilet;
    }

    public void enter() {

        synchronized (toilet) {
            System.out.println("Knock knock " + Thread.currentThread().getName());

            System.out.println(Thread.currentThread().getName() + " entered the bathroom");

            toilet.use();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " is leaving the bathroom");
    }

    public synchronized void washHands() {
        System.out.println(Thread.currentThread().getName() + " lava lava lava, esfrega esfrega esfrega..... mmmmm que cheirinho tao bom!!");
    }
}
