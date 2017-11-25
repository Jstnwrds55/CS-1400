import java.util.Scanner;

public class PigLatinTranslator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the magical Piglatin translator! \n");
        System.out.print("Enter the text to be translated: ");

        // Loop forever unless user types q to quit
        while (true) {

            String[] userSentence = in.nextLine().split("\\s"); // split sentence into an array
            String pigLatinTranslation = "";

            // Break if user types q
            if (userSentence[0].equalsIgnoreCase("Q")) {
                break;
            }

            // loop through words in array and run the translator on each word
            for (String userWord : userSentence) {
                pigLatinTranslation += (WordTranslator(userWord) + " ");
            }

            System.out.println("The translation is: " + pigLatinTranslation + "\n");

            System.out.print("Enter another piece of text to be translated (Or type q to quit): ");
        }
    }

    // actual translating method
    private static String WordTranslator(String userWord) {
        String currentWord = userWord;
        String addToEnd = "";
        String punctuation = "";

        // check if the current word has punctuation
        if (!Character.isLetter(userWord.charAt(userWord.length() - 1))) {
            currentWord = userWord.substring(0, userWord.length() - 1); // remove punctuation from word
            punctuation = Character.toString(userWord.charAt(userWord.length() - 1)); //and put it in here
        }

        // if it starts with a vowel, simply add way and the punctuation and return
        if ("AEIOUaeiou".indexOf(userWord.charAt(0)) != -1) {
            return userWord + "way" + punctuation;
        }

        // special case for words starting with qu
        if (userWord.substring(0, 2).equalsIgnoreCase("qu")) {
            return userWord.substring(2) + "quay" + punctuation;
        }

        // loop until it reaches a vowel
        for (int x = 0; x < currentWord.length(); x++) {

            // If it's past the first letter, include y in the list of letters that starts the translation
            if (x > 0) {

                // if it's a vowel or y, return the piglatin version of the word
                if ("AEIOUYaeiouy".indexOf(currentWord.charAt(x)) != -1) {
                    return currentWord.substring(x) + addToEnd + "ay" + punctuation;

                    // if it's not a vowel, add the consonant to the string to add to the end
                } else {
                    addToEnd = addToEnd + (userWord.charAt(x));
                }

            // If it's not past the first letter, don't include y in the list of letters starting the translation
            } else {

                // If it's a vowel, return the piglatin version of the word
                if ("AEIOUaeiou".indexOf(currentWord.charAt(x)) != -1) {
                    return currentWord.substring(x) + addToEnd + "ay" + punctuation;

                    // if it's not a vowel, add the consonant to the string to add to the end
                } else {
                    addToEnd = addToEnd + (userWord.charAt(x));
                }
            }
        }
        return userWord; // this shouldn't ever be called but it was yelling at me to put a return statement in
    }
}
