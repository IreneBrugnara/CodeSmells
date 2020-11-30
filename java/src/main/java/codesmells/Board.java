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

    private Tile getTile(Position position) {
        return tiles.stream().filter(t -> t.isAt(position)).findFirst().orElse(null);
    }

    public Mark threeInARow() {
        for (int row = 0; row < 3; row++) {
            if (isThreeInAHorizontalRow(row)) return getTile(in(row, 0)).getMark();
        }

        return Mark.NONE;
    }

    private boolean isThreeInAHorizontalRow(int row) {
        Tile firstInRow = getTile(in(row, 0));
        List<Tile> othersInRow = Arrays.asList(getTile(in(row, 1)), getTile(in(row, 2)));
        return firstInRow.isMarked() && othersInRow.stream().allMatch(t -> t.sameMarkAs(firstInRow));
    }
}
