import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.IOException;

/**
 * Get host address and test reachability
 */
public class DNSResolver {

    public static void main(String[] args) {

        String host = getHost();

        try {

           InetAddress address = InetAddress.getByName(host);

           System.out.print("Testing reachability for " + address.getHostAddress() + " : ");
           System.out.println(address.isReachable(1000) ? "OK" : "FAIL");

        } catch (UnknownHostException e) {

            System.err.println("Invalid host name: " + host);

        } catch (IOException e) {

            System.err.println(e.getMessage());

        }

    }

    private static String getHost() {

        Scanner reader = new Scanner(System.in);
        System.out.print("Hostname? ");
        return reader.nextLine();

    }
}
