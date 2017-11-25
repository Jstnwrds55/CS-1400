import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Encrypt {
    public static void main(String[] args) {

        // create scanner and ask for the file name to be encrypted/decrypted
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the the Encryptinator 9000! What file would you like to encrypt/decrypt?");
        String fileName = in.nextLine();
        int increment; // this is 1 if incrementing and -1 if decrementing, then I just add this to the characters rather than having separate code for each

        // loop until the user inputs e or d
        while (true) {
            System.out.println("Type 'e' to encrypt this file and type 'd' to decrypt it.");
            String x = in.next();
            if (x.equalsIgnoreCase("e")) {
                increment = 1;
                break;
            } else if (x.equalsIgnoreCase("d")) {
                increment = -1;
                break;
            } else {
                System.out.println("Make sure you choose to encrypt ('e') or decrypt ('d').");
            }
        }

        Encryptinator(fileName, increment);

    }

    private static void Encryptinator(String fileName, int increment) {

        // declare function scoped variables
        ArrayList<String> lines = new ArrayList<>();
        Scanner fileIn;
        PrintWriter fileOut;
        File f;

        try {

            // declare file and file scanner
            f = new File(fileName);
            fileIn = new Scanner(f);

            // run this loop while there's still another line in the file
            while (fileIn.hasNextLine()) {

                // set current line to the next line from the file and initialize the encrypted line
                String currentLine = fileIn.nextLine();
                String encryptedLine = "";

                // for each character in current word...  if so increment
                for (int x = 0; x < currentLine.length(); x++) {

                    char currentChar = currentLine.charAt(x); // ...see if it's a letter...
                    if (Character.isLetter(currentChar)) {
                        currentChar += increment; // ...if so, increment.

                    }

                    // if original char is a or z and goes out of the alphabetic range, make it the correct letter.\
                    switch ((int) (currentChar)) {
                        case 123:
                            currentChar = 'a';
                            break;
                        case 91:
                            currentChar = 'A';
                            break;
                        case 96:
                            currentChar = 'z';
                            break;
                        case 64:
                            currentChar = 'Z';
                            break;

                    }
                    encryptedLine += currentChar; // concatenate current character onto encrypted line
                }
                lines.add(encryptedLine); // add encrypted line to lines arrayList
            }

            // if it's encrypting, output to file named encrypted.txt, if decrypting to decrypted.txt
            if (increment == 1) {
                fileOut = new PrintWriter("encrypted.txt");
                for (String current : lines) {
                    fileOut.println(current);
                }
                System.out.println("File has been encrypted to 'encrypted.txt'");
                fileOut.close();
            } else if (increment == -1) {
                fileOut = new PrintWriter("decrypted.txt");
                for (String current : lines) {
                    fileOut.println(current);
                }
                System.out.println("File has been decrypted to 'decrypted.txt'");
                fileOut.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Please make sure you choose an existing file.");
        }

    }

}
