import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TicTacToeGameTest {


    private TicTacToeGame game;

    @Before
    public void setUp() throws Exception {
        game = new TicTacToeGame();
    }

    @Test
    public void noWinnerOnANewGame() throws Exception {
        assertThat(game.winner(), is(Player.NO_BODY));
    }

    @Test
    public void playerXIsFirstToPlay() throws Exception {
        game.play(0, 0);
        assertThat(game.playerAt(0, 0), is(Player.X));
    }

    @Test
    public void playerOIsSecondToPlay() throws Exception {
        game.play(0, 0);
        game.play(0, 1);
        assertThat(game.playerAt(0, 1), is(Player.O));
    }

    @Test
    public void playerCanPlayAtAnyValidLocation() throws Exception {
        game.play(2, 2);
        assertThat(game.playerAt(2, 2), is(Player.X));
        game.play(1, 1);
        assertThat(game.playerAt(1, 1), is(Player.O));
    }

    @Test
    public void playerXWinsPlayingTopRow() throws Exception {
        playAndAssertNoWinner(0, 0);
        playAndAssertNoWinner(1, 0);
        playAndAssertNoWinner(0, 1);
        playAndAssertNoWinner(1, 1);
        playAndAssertWinner(0, 2, Player.X);
    }

    @Test
    public void playerYWinsPlayingTopRow() throws Exception {
        playAndAssertNoWinner(2, 0);
        playAndAssertNoWinner(0, 0);
        playAndAssertNoWinner(2, 1);
        playAndAssertNoWinner(0, 1);
        playAndAssertNoWinner(1, 2);
        playAndAssertWinner(0, 2, Player.O);
    }

    private void playAndAssertWinner(int x, int y, Player player) {
        game.play(x, y);
        assertThat(game.winner(), is(player));
    }

    private void playAndAssertNoWinner(int x, int y) {
        game.play(x, y);
        assertNoWinner();
    }


    private void assertNoWinner() {
        assertThat(game.winner(), is(Player.NO_BODY));
    }


}


