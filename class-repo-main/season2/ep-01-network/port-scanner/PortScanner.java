import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanner {

    private static final int DEFAULT_MIN_PORT = 20;
    private static final int DEFAULT_MAX_PORT = 1024;

    private int minPort;
    private int maxPort;
    private InetAddress address;

    public PortScanner(String url) throws UnknownHostException {
        this.minPort = DEFAULT_MIN_PORT;
        this.maxPort = DEFAULT_MAX_PORT;
        this.address = InetAddress.getByName(url);
    }

    public PortScanner(String url, int minPort, int maxPort) throws UnknownHostException {

        this.minPort = minPort;
        this.maxPort = maxPort;
        this.address = InetAddress.getByName(url);

    }

    public void setUrl(String url) throws UnknownHostException {
        this.address = InetAddress.getByName(url);
    }

    public void setMaxPort(int maxPort) {
        this.maxPort = maxPort;
    }

    public void setMinPort(int minPort) {

        this.minPort = minPort;
    }

    public static void main(String[] args) throws UnknownHostException {

        PortScanner scanner = new PortScanner("10.0.0.1");
        scanner.scan();
    }

    public void scan() {

        System.out.println("Scanning " + address.getHostAddress());

        for (int i = minPort; i <= maxPort; i++) {
            System.out.print("Port " + i + " is ");
            System.out.println(scanPort(i) ? "open" : "closed");
        }

    }

    private boolean scanPort(int port) {

        boolean result = false;

        try {

            Socket socket = new Socket(address, port);

        } catch (IOException e) {

            result = false;

        } finally {

            result = true;

        }

        return result;

    }
}
