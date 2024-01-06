// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.
package animal_kingdom;

import java.awt.*;

public class FlyTrap extends Critter {
    public Action getMove(CritterInfo info) {
        if (info.getFront() != Neighbor.OTHER) {
            return Action.LEFT;
        } else {
            return Action.INFECT;
        }
    }

    public Color getColor() {
        return Color.RED;
    }

    public String toString() {
        return "T";
    }
}
