package codesmells;

public class Game {
    private Mark lastMark = Mark.NONE;
    private Board board = new Board();

    public void play(Mark mark, Position position) throws Exception {
        checkMove(mark, position);

        lastMark = mark;
        board.markTileAt(mark, position);
    }

    private void checkMove(Mark mark, Position position) throws Exception {
        if (isFirstPlayInvalid(mark)) {
            throw new Exception("Invalid first player");
        } else if (isRepeatedPlay(mark)) {
            throw new Exception("Invalid next player");
        } else if (board.isMarked(position)) {
            throw new Exception("Invalid position");
        }
    }

    public Mark winner() {
        if (board.hasThreeInARow()) {
            return lastMark;
        }
        return Mark.NONE;
    }

    private boolean isFirstPlayInvalid(Mark mark) {
        return lastMark == Mark.NONE && mark == Mark.O;
    }

    private boolean isRepeatedPlay(Mark mark) {
        return mark == lastMark;
    }

}

