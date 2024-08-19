public class Board {
    public void printBoard(char[] box) {
        System.out.println("\n " + box[6] + " | " + box[7] + " | " + box[8] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[0] + " | " + box[1] + " | " + box[2] + " \n");
    }

    public void clearBoard(char[] box) {
        for (int i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }
}
