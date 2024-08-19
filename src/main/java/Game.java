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

    public static void main(String[] args) {
        new Game().startGame();
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        boolean boxEmpty = false;
        byte winner = 0;
        boolean gameFinished = false;

        System.out.println("Choose a position:");

        Board board = new Board();
        Player player = new Player();
        Computer computer = new Computer();
        GameStateChecker checker = new GameStateChecker();

        while (!gameFinished) {
            board.printBoard(box);

            if (!boxEmpty) {
                board.clearBoard(box);
                boxEmpty = true;
            }

            if (checker.checkWinner(winner)) {
                gameFinished = true;
            } else {
                player.playerMove(scan, box);

                if (checker.checkVictory(box, 'X')) {
                    winner = 1;
                } else if (!checker.isBoxAvailable(box)) {
                    winner = 3;
                } else {
                    computer.computerMove(box);

                    if (checker.checkVictory(box, 'O')) {
                        winner = 2;
                    }
                }
            }
        }
    }
}