import java.util.Iterator;

/**
 * Created by ferrao on 30/05/16.
 */
public class RangeTest {

    public static void main(String[] args) {

        System.out.println("--- USING ENHANCED FOR WITH FORWARD ITERATOR ---");
        Range r = new Range(3, 9);
        r.setReversed(false);

        for (Integer i : r) {
            System.out.println(i);
        }

        System.out.println("--- USING FORWARD ITERATOR ---");
        Iterator<Integer> it = r.iterator();

        while (it.hasNext()) {

            int i = it.next();
            System.out.println(i);

            if (i == 8 || i == 9) {
                System.out.println("Removed " + i);
                it.remove();
            }

        }

        System.out.println("--- USING NEW FORWARD ITERATOR ---");
        it = r.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("--- USING REVERSE ITERATOR ---");
        r.setReversed(true);
        it = r.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //it.next();

    }

}
