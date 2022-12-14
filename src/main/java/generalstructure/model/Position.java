package generalstructure.model;

import java.util.*;

public record Position (int row, int col) {

    public List<Position> next (int rowCount, int colCount) {
        List<Position> list = new ArrayList<>();
        if (row() > 0) list.add(new Position(row() - 1, col()));
        if (col() > 0) list.add(new Position(row(), col() - 1));
        if (row() < rowCount - 1) list.add(new Position(row() + 1, col()));
        if (col() < colCount - 1) list.add(new Position(row(), col() + 1));
        return list;
    }

    public static Position randomPosition(int rowCount, int colCount) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }
}
