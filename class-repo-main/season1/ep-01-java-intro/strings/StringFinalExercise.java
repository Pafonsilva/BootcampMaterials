// We could use RegEx's with capture groups, eg: echo "abcrui" | sed -E 's/abc(.*)/\1/'  -> output will be rui

class StringFinalExercise {

    public static void main(String[] args) {

        String url = "http://www.academiadecodigo.org";

        String domain = url.substring(url.lastIndexOf("/") + 1); // www.academiadecodigo.org

        String name = url.substring(url.indexOf(".") + 1, url.lastIndexOf(".")); // academiadecodigo

        int academiaEnd = name.lastIndexOf("a"); // get last "a" of academia
        int codigoStart = name.lastIndexOf("c"); // get first "c" of codigo

        String academia = name.substring(0, academiaEnd + 1);     // academia
        String de = name.substring(academiaEnd + 1, codigoStart); // de
        String codigo = name.substring(codigoStart);              // codigo

        academia = academia.substring(0, 1).toUpperCase() + academia.substring(1);  // Academia
        codigo = codigo.substring(0, 1).toUpperCase() + codigo.substring(1);        // Codigo

        name = "< " + academia + " " + de + " " + codigo + "_ >"; // < Academia de Codigo_ >

        System.out.println("I am a Code Cadet at " + name + ", " + domain);
    }
}

/*
public class StringManipulation {

    public static void main(String[] args) {

        String str = "http://www.academiadecodigo.org";
        String domain = str.replaceAll(".*www", "www");

        String firstWord = domain.substring(domain.indexOf(".") + 1, domain.lastIndexOf("a") + 1);
        String secondWord = domain.substring(domain.indexOf(firstWord) + firstWord.length(), domain.lastIndexOf("c"));
        String thirdWord = domain.substring(domain.lastIndexOf(secondWord) + secondWord.length(), domain.lastIndexOf("."));

        String name ="< " + firstWord.substring(0,1).toUpperCase() + firstWord.substring(1) + " "
                          + secondWord + " "
                          + thirdWord.substring(0,1).toUpperCase() + thirdWord.substring(1) + "_ >";

        System.out.println("I am a Master Coder at " + name + ", " + domain);
    }
} */
