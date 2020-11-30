package codesmells;

public class Tile
{
    private Position position;
    private Mark mark;

    public static Tile empty(Position position) {
        return new Tile(position, Mark.NONE);
    }

    private Tile(Position position, Mark mark) {
        this.position = position;
        this.mark = mark;
    }

    public void markWith(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    public boolean isAt(Position position) {
        return this.position.equals(position);
    }

    public boolean sameMarkAs(Tile other) {
        return mark == other.mark;
    }

    public boolean isMarked() {
        return mark != Mark.NONE;
    }
}
