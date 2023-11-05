import java.util.stream.IntStream;

public class PerfectNumber {

    public static void main(String[] args) {

        PerfectNumber perfectNumber = new PerfectNumber();

        long start = System.currentTimeMillis();

        perfectNumber.checkPerfectsBetter(6);

        double elapsed = (System.currentTimeMillis() - start) / 1000;
        System.out.println(elapsed < 60d ? "time (secs): " + elapsed : "time (mins): " + elapsed/60);
    }

    public int sumDivisors(int n) {
        return IntStream.range(1,n)
                .filter(x -> n % x == 0)
                .sum();
    }

    public void checkPerfect(int min, int max) {
        IntStream.range(min, max)
                .filter(n -> n == sumDivisors(n))
                .parallel()
                .forEach(System.out::println);
    }

    public int sumDivisorsBetter(int n) {
        int root = (int) Math.sqrt(n);
        int sum = IntStream.rangeClosed(2, root)
                .filter(x -> n % x == 0)
                .parallel()
                .map(x -> x + n / x)
                .sum();

        if (n == root * root) {
            sum -= root;
        }

        return sum + 1;
    }

    public void checkPerfectsBetter(int limit) {
        IntStream.iterate(1, n -> n + 1)
                .unordered()
                .filter(n -> n == sumDivisorsBetter(n))
                .parallel()
                .limit(limit)
                .forEach(System.out::println);
    }
}
