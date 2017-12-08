import java.util.InputMismatchException;
import java.util.Scanner;

class StartGame {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Roulette r = new Roulette();
        Double bet = 1.0;


        r.betOnce(in, bet);
    }
}