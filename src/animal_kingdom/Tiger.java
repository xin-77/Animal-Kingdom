package animal_kingdom;

import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
	private int step;
	private Random random = new Random();
	private Color[] color = { Color.RED, Color.GREEN, Color.BLUE };
	private Color c = color[random.nextInt(3)];

	public Tiger() {
	}
	/*Chooses one of three colours at random (Color.RED, Color.GREEN, Color.BLUE)
	and uses that colour for three moves, then chooses one of those
	colours again for the next three moves, then another one of those
	colours for the next three moves, and so on.*/
	public Color getColor() {
		if (step % 3 != 0) {
			return c;
		}
		c = color[random.nextInt(3)];
		return c;
	}

	//"TGR"
	public final String toString() {
		return "TGR";
	}
	/*If an enemy is in front, always infect; otherwise,
	if a wall is in front or to the right, turn left; otherwise,
	if a fellow Tiger is in front, turn right; otherwise, hop..*/
	public Action getMove(CritterInfo info) {
		step++;
		if (info.getFront() != Neighbor.OTHER) {
			if (info.getFront() != Neighbor.WALL && info.getRight() != Neighbor.WALL) {
				if (info.getFront() != Neighbor.SAME) {
					return Action.HOP;
				}
				return Action.RIGHT;
			} else {
				return Action.LEFT;
			}
		} else {
			return Action.INFECT;
		}
	}


}
