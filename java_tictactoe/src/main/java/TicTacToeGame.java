public class TicTacToeGame {

    private Player[][] board = new Player[][] {
            {Player.NO_BODY, Player.NO_BODY, Player.NO_BODY},
            {Player.NO_BODY, Player.NO_BODY, Player.NO_BODY},
            {Player.NO_BODY, Player.NO_BODY, Player.NO_BODY}
    };

    private Player[]  players = new Player[] { Player.X , Player.O};
    private int playerIndex = 0;

    public Player winner() {
        if (checkTopRow(Player.X)) return Player.X;
        else if (checkTopRow(Player.O)) return Player.O;
        return Player.NO_BODY;
    }

    private boolean checkTopRow(Player x) {
        return board[0][0].equals(x) && board[0][1].equals(x) && board[0][2].equals(x);
    }

    public void play(int x, int y) {
        board[x][y] = players[playerIndex++ % 2 == 0 ? 0 : 1];
    }

    public Player playerAt(int x, int y) {
        return board[x][y];
    }
}
