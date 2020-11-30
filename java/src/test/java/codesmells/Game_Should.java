package codesmells;

import org.junit.Before;
import org.junit.Test;

import static codesmells.Position.in;
import static org.junit.Assert.assertEquals;

public class Game_Should {
    private Game game;

    @Before
    public void InitializeGame(){
        game = new Game();
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerOToPlayFirst() throws Exception {
        game.play(Mark.O, in(0, 0));
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerXToPlayTwiceInARow() throws Exception
    {
        game.play(Mark.X, in(0, 0));

        game.play(Mark.X, in(1, 0));
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInLastPlayedPosition() throws Exception
    {
        game.play(Mark.X, in(0, 0));

        game.play(Mark.O, in(0, 0));
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInAnyPlayedPosition() throws Exception
    {
        game.play(Mark.X, in(0, 0));
        game.play(Mark.O, in(1, 0));

        game.play(Mark.X, in(0, 0));
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(Mark.X, in(0, 0));
        game.play(Mark.O, in(1, 0));
        game.play(Mark.X, in(0, 1));
        game.play(Mark.O, in(1, 1));
        game.play(Mark.X, in(0, 2));

        Mark winner = game.winner();

        assertEquals(Mark.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(Mark.X, in(2, 2));
        game.play(Mark.O, in(0, 0));
        game.play(Mark.X, in(1, 0));
        game.play(Mark.O, in(0, 1));
        game.play(Mark.X, in(1, 1));
        game.play(Mark.O, in(0, 2));

        Mark winner = game.winner();

        assertEquals(Mark.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(Mark.X, in(1, 0));
        game.play(Mark.O, in(0, 0));
        game.play(Mark.X, in(1, 1));
        game.play(Mark.O, in(0, 1));
        game.play(Mark.X, in(1, 2));

        Mark winner = game.winner();

        assertEquals(Mark.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(Mark.X, in(0, 0));
        game.play(Mark.O, in(1, 0));
        game.play(Mark.X, in(2, 0));
        game.play(Mark.O, in(1, 1));
        game.play(Mark.X, in(2, 1));
        game.play(Mark.O, in(1, 2));

        Mark winner = game.winner();

        assertEquals(Mark.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(Mark.X, in(2, 0));
        game.play(Mark.O, in(0, 0));
        game.play(Mark.X, in(2, 1));
        game.play(Mark.O, in(0, 1));
        game.play(Mark.X, in(2, 2));

        Mark winner = game.winner();

        assertEquals(Mark.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(Mark.X, in(0, 0));
        game.play(Mark.O, in(2, 0));
        game.play(Mark.X, in(1, 0));
        game.play(Mark.O, in(2, 1));
        game.play(Mark.X, in(1, 1));
        game.play(Mark.O, in(2, 2));

        Mark winner = game.winner();

        assertEquals(Mark.O, winner);
    }
}
