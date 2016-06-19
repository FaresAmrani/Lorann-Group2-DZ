package lorann.game;

import java.io.IOException;

import lorann.game.controller.LorannController;
import lorann.game.model.GameBoard;
import lorann.game.model.IGameBoard;
import lorann.game.view.LorannFrame;

public class Lorann{
	IGameBoard gameBoard;
	LorannFrame frame;
	public Lorann() throws IOException{
	IGameBoard gameBoard = new GameBoard("lvl2");
	LorannFrame frame = new LorannFrame(gameBoard);
	LorannController controller = new LorannController(gameBoard, frame);
	frame.setController(controller);
	}
}
