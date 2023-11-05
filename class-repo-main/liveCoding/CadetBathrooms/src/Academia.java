public class Academia {

    public static void main(String[] args) {

        Bathroom bathroom = new Bathroom(new Toilet());

        Thread thread = new Thread(new Cadet("Mendanha" , bathroom));
        Thread thread1 = new Thread(new Cadet("Soeiro", bathroom));
        Thread thread2 = new Thread(new Cadet("Branco", bathroom));


        thread.start();
        thread1.start();
        thread2.start();
    }
}
