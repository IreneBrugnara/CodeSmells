package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> tiles = new ArrayList<>();

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                tiles.add(Tile.empty(row, column));
            }
        }
    }

    public void markTileAt(Mark mark, int x, int y) {
        tileAt(x, y).markWith(mark);
    }

    public boolean alreadyPlayedAt(int x, int y) {
        return tileAt(x, y).isMarked();
    }

    private Tile tileAt(int row, int column) {
        return tiles.stream().filter(t -> t.isAt(row, column)).findFirst().orElse(null);
    }

    public Mark threeInARow() {
        for (int i = 0; i < 3; i++) {
            if (isThreeInAHorizontalRowAt(i)) return tileAt(i, 0).getMark();
        }

        return Mark.NONE;
    }

    private boolean isThreeInAHorizontalRowAt(int i) {
        return tileAt(i, 0).sameMarkAs(tileAt(i, 1)) && tileAt(i, 2).sameMarkAs(tileAt(i, 1)) && tileAt(i, 0).isMarked();
    }
}
