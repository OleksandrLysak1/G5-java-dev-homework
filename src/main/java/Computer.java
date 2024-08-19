public class Computer {
    public void computerMove(char[] box) {
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
