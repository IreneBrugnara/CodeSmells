package codesmells;

public class Tile
{
    private final int x;
    private final int y;
    private Mark mark;

    public static Tile empty(int x, int y) {
        return new Tile(x, y, Mark.NONE);
    }

    private Tile(int x, int y, Mark mark) {
        this.x = x;
        this.y = y;
        this.mark = mark;
    }

    public void markWith(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    public boolean isAt(int x, int y) {
        return this.x == x && this.y == y;
    }

    public boolean sameMarkAs(Tile other) {
        return mark == other.mark;
    }

    public boolean isMarked() {
        return mark != Mark.NONE;
    }
}
