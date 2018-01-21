import java.util.ArrayList;
import java.util.Random;

public class App {
	/**
	 * Function that starts the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Game firstGame = new Game();

		firstGame.drawGameBoard();

	}
}

/**
 * Class respond for control and display game
 * 
 * @author Miko³aj Chojnacki
 *
 */
class Game {

	private String[][] gameBoard = new String[][] {
			{ "  ", " A ", "B ", "C ", "D ", "E ", "F ", "G ", "H ", "I ", "J " },
			{ "1  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "2  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "3  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "4  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "5  ", "- ", "- ", "- ", "- ", "  ", "- ", "- ", "- ", "- ", "- " },
			{ "6  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "7  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "8  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "9  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "10 ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " }, };
	private int shipNumbersLeft = 0;
	private ArrayList<String> ships = new ArrayList<String>();

	public Game() {
		generateShips();
	}

	/**
	 * method generates random ships and set them to ships array
	 */
	private void generateShips() {

		Random rand = new Random();

		while (getShipNumbersLeft() < 20) {

			int x = (int) (Math.random() * 10 + 1);
			int y = (int) (Math.random() * 10 + 1);

			getShips().add(x+","+y);
			System.out.println(getShips());

			setShipNumbersLeft(getShipNumbersLeft() + 1);
			
		}

	}

	/**
	 * Draw game board
	 */
	public void drawGameBoard() {

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(getGameBoard()[i][j]);
			}
			System.out.println("");
		}

	}

	public int getShipNumbersLeft() {
		return shipNumbersLeft;
	}

	public void setShipNumbersLeft(int shipNumbersLeft) {
		this.shipNumbersLeft = shipNumbersLeft;
	}

	public String[][] getGameBoard() {
		return gameBoard;
	}

	public ArrayList<String> getShips() {
		return ships;
	}

	public void setShips(ArrayList<String> ships) {
		this.ships = ships;
	}

}