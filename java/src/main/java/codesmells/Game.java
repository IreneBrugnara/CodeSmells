package codesmells;

public class Game {
    private Mark _lastSymbol = Mark.NONE;
    private Board _board = new Board();

    public void Play(Mark mark, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == Mark.NONE) {
            if (mark == Mark.O) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (mark == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.alreadyPlayedAt(x, y)) {
            throw new Exception("Invalid position");
        }

        _lastSymbol = mark;
        _board.markTileAt(mark, x, y);
    }

    public Mark Winner() {
        return _board.threeInARow();
    }

}

