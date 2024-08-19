import java.util.Scanner;

public class Player {
    public void playerMove(Scanner scan, char[] box) {
        boolean validMove = false;
        while (!validMove) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == '0') {
                    System.out.println("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = 'X';
                    validMove = true;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }
}
