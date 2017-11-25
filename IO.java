import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class IO {
    public static void main(String[] args) {
        try {
            File f = new File("/Users/admin/IdeaProjects/CS 1400/src/blah.txt");
            Scanner fileIn = new Scanner(f);
            String word = "";
            int count = 0;

            while (fileIn.hasNext()) {
                word = fileIn.next();
                count++;

            }

            System.out.println("there are " + count + " words in the file.");


        } catch (FileNotFoundException e) {
            System.out.println("Sorry bad file name, try again");
        }
        try {
            PrintWriter fileOut = new PrintWriter("/Users/admin/IdeaProjects/CS 1400/src/heyyy.txt");
            fileOut.println("Just wanted to do some writing dude");
            fileOut.println("Here's some more writing!");
            fileOut.close();
        } catch (FileNotFoundException x) {
            System.out.println("Sorry can't save there!");
        }







    }


}
