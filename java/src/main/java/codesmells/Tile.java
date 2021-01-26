package codesmells;

public class Tile
{
    public int X;
    public int Y;
    private char Symbol;

    public Tile(int x, int y, char symbol) {
        X = x;
        Y = y;
        setSymbol(symbol);
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}
