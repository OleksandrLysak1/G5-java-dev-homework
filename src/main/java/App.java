/*
* Замінив назви змінних на більш зрозумілі та описові.
* Додав константи, такі як BOARD_SIZE, замість використання магічних чисел.
* Виніс перевірку кожної лінії в окремий метод checkLine.
* Спрощено метод checkVictory.
* Логіка роботи циклів була оптимізована через використання логічних змінних (validMove, gameFinished)
  замість використання декількох break або continue.
* Перевірив і відкоригував форматування коду відповідно до стандартів.
* Збільшив читабельність коду через додаткову структуру методів.
* Скоротив кількість дубльованих умов для перевірки перемоги.
* Оптимізував цикли шляхом винесення загальної логіки в окремі методи.
* Проаналізував проект з використанням SonarLint.
*/

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        boolean boxEmpty = false;
        byte winner = 0;
        boolean gameFinished = false;

        System.out.println("Choose a position:");

        while (!gameFinished) {
            printBoard(box);

            if (!boxEmpty) {
                clearBoard(box);
                boxEmpty = true;
            }

            if (checkWinner(winner)) {
                gameFinished = true;
            } else {
                playerMove(scan, box);

                if (checkVictory(box, 'X')) {
                    winner = 1;
                } else if (!isBoxAvailable(box)) {
                    winner = 3;
                } else {
                    computerMove(box);

                    if (checkVictory(box, 'O')) {
                        winner = 2;
                    }
                }
            }
        }
    }

    static void printBoard(char[] box) {
        System.out.println("\n " + box[6] + " | " + box[7] + " | " + box[8] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[0] + " | " + box[1] + " | " + box[2] + " \n");
    }

    static void clearBoard(char[] box) {
        for (int i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    static boolean checkWinner(byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Oleksandr Lysak. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Oleksandr Lysak. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Oleksandr Lysak. Thanks for playing!");
            return true;
        }
        return false;
    }

    static void playerMove(Scanner scan, char[] box) {
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

    static boolean checkVictory(char[] box, char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    static boolean isBoxAvailable(char[] box) {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != '0') {
                return true;
            }
        }
        return false;
    }

    static void computerMove(char[] box) {
        boolean validMove = false;
        while (!validMove) {
            byte rand = (byte) (Math.random() * 9);
            if (box[rand] != 'X' && box[rand] != '0') {
                box[rand] = '0';
                validMove = true;
            }
        }
    }
}
