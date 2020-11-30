package codesmells;

public class Game {
    private Mark lastMark = Mark.NONE;
    private Board board = new Board();

    public void play(Mark mark, int x, int y) throws Exception {
        if (isFirstPlayInvalid(mark)) {
            throw new Exception("Invalid first player");
        } else if (isRepeatedPlay(mark)) {
            throw new Exception("Invalid next player");
        } else if (board.alreadyPlayedAt(x, y)) {
            throw new Exception("Invalid position");
        }

        lastMark = mark;
        board.markTileAt(mark, x, y);
    }

    public Mark winner() {
        return board.threeInARow();
    }

    private boolean isFirstPlayInvalid(Mark mark) {
        return lastMark == Mark.NONE && mark == Mark.O;
    }

    private boolean isRepeatedPlay(Mark mark) {
        return mark == lastMark;
    }

}

