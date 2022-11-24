package Model.Manager;

import Model.Entity.*;
import Util.Position;
import java.util.*;

public class FireFighterManager extends Manager {

    private final Extinguisher fireManager;

    public List<FireFighter> fireFighters = new ArrayList<>();

    public FireFighterManager (int amount, FireManager fireManager) {
        super(amount);
        this.fireManager = fireManager;
    }

    @Override
    public void initialize(int rowCount, int colCount) {
        for (int index = 0; index < amount; index++) fireFighters.add(new FireFighter(randomPosition(rowCount, colCount)));
    }

    @Override
    public void update(int rowCount, int colCount) {
        List<FireFighter> fireFightersNewPositions = new ArrayList<>();
        for (FireFighter fireFighter : fireFighters) {
            Position randomPosition = fireManager.aStepTowardFire(fireFighter.getPosition(), rowCount, colCount);
            List<Position> nextFires = randomPosition.next(rowCount, colCount);
            fireManager.extinguishFire(fireManager.containsFire(randomPosition));
            for (Position fire : nextFires) {
                fireManager.extinguishFire(fireManager.containsFire(fire));
            }
            fireFightersNewPositions.add(new FireFighter(randomPosition));

        }
        fireFighters = fireFightersNewPositions;
    }

    @Override
    public Set<Entity> getEntities() {
        return new HashSet<>(fireFighters);
    }
}
