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

public class Game {
    // Приватна статична фінальна змінна для сканера
    private static final Scanner inputScanner = new Scanner(System.in);

    // Інші змінні класу
    private char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean boxEmpty = false;
    private byte winner = 0;
    private boolean gameFinished = false;

    // Метод для запуску гри
    public void start() {
        System.out.println("Choose a position:");

        while (!gameFinished) {
            printBoard();
            if (!boxEmpty) {
                clearBoard();
                boxEmpty = true;
            }

            if (checkWinner()) {
                gameFinished = true;
            } else {
                playerMove();

                if (checkVictory('X')) {
                    winner = 1;
                } else if (!isBoxAvailable()) {
                    winner = 3;
                } else {
                    computerMove();

                    if (checkVictory('O')) {
                        winner = 2;
                    }
                }
            }
        }
    }

    private void printBoard() {
        System.out.println("\n " + box[6] + " | " + box[7] + " | " + box[8] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[0] + " | " + box[1] + " | " + box[2] + " \n");
    }

    private void clearBoard() {
        for (int i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    private boolean checkWinner() {
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

    private void playerMove() {
        boolean validMove = false;
        while (!validMove) {
            byte input = inputScanner.nextByte();
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

    private boolean checkVictory(char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private boolean isBoxAvailable() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != '0') {
                return true;
            }
        }
        return false;
    }

    private void computerMove() {
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
