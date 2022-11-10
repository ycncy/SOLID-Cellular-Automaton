package Grid;

import Util.Position;

public class Fire implements Element {

    public Grid grid;
    public Position position;

    public Fire(Grid grid, Position position) {
        this.grid = grid;
        this.position = position;
    }

    @Override
    public void activate (Position position, Grid grid) {
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFire(this);
    }
}
