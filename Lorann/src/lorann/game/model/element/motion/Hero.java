package lorann.game.model.element.motion;

import lorann.game.model.Direction;

public class Hero extends Mobile {
	Direction direction = Direction.LEFT;
	public Hero(int x, int y){
		super(x, y, "lorann_LEFT", 'H');
	}
	
	@Override
	public void move(Direction u){
		this.gameBoard.getHero().setImage("lorann_"+u);
		System.out.println("lorann_"+u);
		super.move(u);
		direction = u;
	}
	
	public void castFire(){
		new Fireball(this.getX(), this.getY(), this.direction);
	}
	
}
