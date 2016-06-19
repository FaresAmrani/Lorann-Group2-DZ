package lorann.game.controller;

import lorann.game.model.Direction;
import lorann.game.model.IGameBoard;
import lorann.game.view.LorannFrame;

public class LorannController {
	private IGameBoard gameBoard;
	private LorannFrame frame;
	public long lastTime;
	
	public LorannController(IGameBoard gameBoard, LorannFrame frame){
		this.gameBoard = gameBoard;
		this.frame = frame;
		this.lastTime = System.currentTimeMillis();
	}

	public IGameBoard getGameBoard() {
		return gameBoard;
	}

	public LorannFrame getFrame() {
		return frame;
	}
	
	public void updateModel(){
	if(System.currentTimeMillis()-lastTime>=100){
		//TODO verifie si un bouton est appuyé, si oui, déplace le héro dans la direction voulue
		//boule de feu si espace
		//update X, Y des monstres
		//update l'image du héro et de la boule de feu
		lastTime = System.currentTimeMillis();
	}
	}
	
	public void order(Direction dir){
		this.getGameBoard().getHero().move(dir);
		refreshScreen();

	}
	
	public void refreshScreen(){
		this.getFrame().repaint();
	}
}
