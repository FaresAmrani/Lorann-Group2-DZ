package lorann.game.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import lorann.game.controller.LorannController;
import lorann.game.model.Direction;
import lorann.game.model.IGameBoard;

public class LorannFrame extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private LorannController controller;
	public boolean pressedUp, pressedDown, pressedLeft, pressedRight;
	
	public LorannFrame(IGameBoard gameBoard){
		setResizable(false);
		setTitle("Lorann");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.black);
		GameBoardPanel grille = new GameBoardPanel(gameBoard);
		add(grille);
		pack();
		this.addKeyListener(this);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	//TODO pressedDirection booleans for keypressed & released to know what action to trigger
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_UP){
			//this.getController().order(Direction.UP);
			pressedUp = true;
		}
		else if(keycode == KeyEvent.VK_LEFT){
			this.getController().order(Direction.LEFT);
		}
		else if(keycode == KeyEvent.VK_RIGHT){
			this.getController().order(Direction.RIGHT);
		}
		else if(keycode == KeyEvent.VK_DOWN){
			if(keycode == KeyEvent.VK_LEFT){
				this.getController().order(Direction.DOWNLEFT);
			}
			if(keycode == KeyEvent.VK_RIGHT){
				this.getController().order(Direction.DOWNRIGHT);
			} else {
			this.getController().order(Direction.DOWN);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_UP){
			//this.getController().order(Direction.UP);
			pressedUp = false;
		}
		
	}

	public LorannController getController() {
		return controller;
	}

	public void setController(LorannController controller) {
		this.controller = controller;
	}

}
