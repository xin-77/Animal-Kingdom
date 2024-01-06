package animal_kingdom;

import java.awt.*;

public class WhiteTiger extends Critter {
	private boolean infected = false;
	//constructor
	public WhiteTiger() {

	}

	//Always Color.WHITE.
	public final Color getColor() {
		return Color.WHITE;
	}
	//“tgr” if it hasn’t infected another Critter yet, “TGR” if it has infected.
	public String toString() {
		if (infected) {
			return "tgr";
		}
		return "TGR";
	}
	//Same as a Tiger. Note: you’ll have to override this method to figure out if it has infected another Critter.
	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			infected = true;
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			infected = true;
			return Action.RIGHT;
		}
		return Action.HOP;
	}


}
