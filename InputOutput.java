import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class InputOutput {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        File f;
        Scanner fileIn;
        String fileName = "";
        ArrayList<String> words = new ArrayList<String>();

        char alphabet = 'A';
        alphabet --;
        System.out.println(alphabet);

        System.out.println("Please enter the name of the file you want to print out backwards");
        fileName = in.nextLine();

        // build file and attach scanner



        try {
            f = new File(fileName);
            fileIn = new Scanner(f);
            PrintWriter fileOut = new PrintWriter("/Users/admin/IdeaProjects/CS 1400/src/backwards.txt");

            // loop through array and add words to array
            while (fileIn.hasNext()) {
                words.add(fileIn.next());
            }

            for (int x = words.size() - 1; x >= 0; x --) {
                fileOut.print(words.get(x) + " ");

            }
            fileOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("NO");
        }


    }
}
