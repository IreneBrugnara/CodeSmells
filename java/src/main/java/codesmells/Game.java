package codesmells;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.SymbolAt(x, y) != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (_board.SymbolAt(0, 0) != ' ' &&
                _board.SymbolAt(0, 1) != ' ' &&
                _board.SymbolAt(0, 2) != ' ') {
            //if first row is full with same symbol
            if (_board.SymbolAt(0, 0) ==
                    _board.SymbolAt(0, 1) &&
                    _board.SymbolAt(0, 2) == _board.SymbolAt(0, 1)) {
                return _board.SymbolAt(0, 0);
            }
        }

        //if the positions in first row are taken
        if (_board.SymbolAt(1, 0) != ' ' &&
                _board.SymbolAt(1, 1) != ' ' &&
                _board.SymbolAt(1, 2) != ' ') {
            //if middle row is full with same symbol
            if (_board.SymbolAt(1, 0) ==
                    _board.SymbolAt(1, 1) &&
                    _board.SymbolAt(1, 2) ==
                            _board.SymbolAt(1, 1)) {
                return _board.SymbolAt(1, 0);
            }
        }

        //if the positions in first row are taken
        if (_board.SymbolAt(2, 0) != ' ' &&
                _board.SymbolAt(2, 1) != ' ' &&
                _board.SymbolAt(2, 2) != ' ') {
            //if middle row is full with same symbol
            if (_board.SymbolAt(2, 0) ==
                    _board.SymbolAt(2, 1) &&
                    _board.SymbolAt(2, 2) ==
                            _board.SymbolAt(2, 1)) {
                return _board.SymbolAt(2, 0);
            }
        }

        return ' ';
    }

}

