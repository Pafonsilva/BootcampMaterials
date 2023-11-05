import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Integer range (reverse) iterator
 */
public class Range implements Iterable<Integer> {

    private int min;
    private int max;

    private List<Integer> removed;

    private boolean reversed;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
        removed = new LinkedList<>();
    }

    /**
     * Reversed setter
     *
     * @param reversed boolean value to set
     */
    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    @Override
    public Iterator<Integer> iterator() {

        return !reversed ? ascendingIterator() : descendingIterator();
    }

    private Iterator<Integer> descendingIterator() {

        return new Iterator<Integer>() {

            private int current = max + 1;

            @Override
            public boolean hasNext() {

                while (removed.contains(current - 1)) {
                    current--;
                }

                return current > min;
            }

            @Override
            public Integer next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                current--;

                return current;
            }

            @Override
            public void remove() {

                if (current > max) {
                    throw new IllegalStateException("You need to call next() at least once to remove an element.");
                }

                if (removed.contains(current)) {
                    throw new IllegalStateException("You cannot call remove() repeatedly");
                }

                removed.add(current);
            }
        };
    }

    private Iterator<Integer> ascendingIterator() {

        return new Iterator<Integer>() {
            // You need to call next() to get the first element.
            private int current = min - 1;

            @Override
            public boolean hasNext() {
                while (removed.contains(current + 1)) {
                    current++;
                }
                return current < max;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current++;
                return current;
            }

            @Override
            public void remove() {

                // if you try to remove an element before calling next(), you will get a runtime exception (see Iterable:remove() description)
                if (current < min) {
                    throw new IllegalStateException("You need to call next() at least once to remove an element.");
                }

                // if you try to call remove() consecutively you will get a runtime exception (see Iterable:remove() description)
                if (removed.contains(current)) {
                    throw new IllegalStateException("You cannot call remove() repeatedly");
                }

                removed.add(current);
            }
        };

    }

}

