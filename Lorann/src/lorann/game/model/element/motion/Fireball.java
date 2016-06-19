package lorann.game.model.element.motion;

import lorann.game.model.Direction;

public class Fireball extends Mobile {
	final Direction u;
	public Fireball(int x, int y, Direction u){
		super(x, y, "fireball_1", 'H');
		this.u = u;
	}
	
	//TODO changes the img as it moves setting up img array
	
	public void move(){
		super.move(this.u);
	}
	
}

