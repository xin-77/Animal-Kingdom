package animal_kingdom;

import java.awt.*;
import java.util.Random;

public class Bear extends Critter {
	private boolean polar;
	private String move;
	private Color color;

	//constructor
	public Bear() {
		move = "/";
		Random random=new Random();
		if(random.nextInt(2)==1) {
			polar=true;
		}
	}

	public Bear(boolean polar) {
		this.polar = polar;
		move = "/";
		if (polar) {
			this.color = Color.WHITE;
		}
		this.color = Color.BLACK;
	}
	//For a polar bear, use color.WHITE (when polar is true),
	//Otherwise, color.BLACK (when polar is false)
	public Color getColor() {

		if (polar) {
			return Color.WHITE;
		}
		return Color.BLACK;
	}

	/*Should alternate on each different move between a slash character(/)
    and a backslash character () starting with a slash.*/
	public String toString() {
		if (move.equals("\\")) {
			this.move = "/";
			return "/";
		}
		this.move = "\\";
		return "\\";
	}

	/*If an enemy is in front, always infect; otherwise, hop if possible;
	   otherwise, turn left.*/

	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		return Action.LEFT;
	}
}
