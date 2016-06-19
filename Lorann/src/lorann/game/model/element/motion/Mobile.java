package lorann.game.model.element.motion;

import lorann.game.model.Direction;
import lorann.game.model.element.Element;
import lorann.game.model.element.Permeability;

public abstract class Mobile extends Element {
	
	private int x;
	private int y;
	
	public Mobile(int x, int y, String imageName, char c){
		super(imageName, c, Permeability.PASS);
		this.x=x;
		this.y=y;
	}

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void move(Direction u){
		this.gameBoard.moveMobile(this, u);
	}
	
}
