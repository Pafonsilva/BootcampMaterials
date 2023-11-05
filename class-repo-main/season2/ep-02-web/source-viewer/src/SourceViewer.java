import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SourceViewer {

    public static void main(String[] args) {

        String urlString = getUrl();
        InputStream in = null;

        try {

            URL url = new URL(urlString);
            in = new BufferedInputStream(url.openStream());
            InputStreamReader reader = new InputStreamReader(in);

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (MalformedURLException e) {

            System.out.println("Invalid URL: " + urlString);

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }

    }

    private static String getUrl() {

        Scanner reader = new Scanner(System.in);
        System.out.print("URL? ");
        return reader.nextLine();

    }
}
