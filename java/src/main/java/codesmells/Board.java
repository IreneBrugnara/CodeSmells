package codesmells;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static codesmells.Position.in;

public class Board {
    private List<Tile> tiles = new ArrayList<>();

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                tiles.add(Tile.empty(in(row, column)));
            }
        }
    }

    public void markTileAt(Mark mark, Position position) {
        getTile(position).markWith(mark);
    }

    public boolean isMarked(Position position) {
        return getTile(position).isMarked();
    }

    public boolean hasThreeInARow() {
        return isThreeInARow(horizontal(0)) || isThreeInARow(horizontal(1)) || isThreeInARow(horizontal(2));
    }

    private boolean isThreeInARow(List<Tile> row) {
        return row.get(0).isMarked() && row.stream().allMatch(t -> t.sameMarkAs(row.get(0)));
    }

    private List<Tile> horizontal(int row) {
        return Arrays.asList(getTile(in(row, 0)), getTile(in(row, 1)), getTile(in(row, 2)));
    }

    private Tile getTile(Position position) {
        return tiles.stream().filter(t -> t.isAt(position)).findFirst().orElse(null);
    }
}
