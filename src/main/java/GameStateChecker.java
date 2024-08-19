public class GameStateChecker {
    public boolean checkVictory(char[] box, char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    public boolean isBoxAvailable(char[] box) {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != '0') {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinner(byte winner) {
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
}
