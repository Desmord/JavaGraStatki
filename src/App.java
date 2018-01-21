import java.util.ArrayList;
import java.util.Arrays;
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
			{ "5  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "6  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "7  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "8  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "9  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "10 ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " }, };
	private int shipNumbersLeft = 0;
	private String[] ships = new String[20];

	public Game() {
		generateShips();
	}

	/**
	 * method generates random ships and set them to 'ships' array
	 */
	private void generateShips() {

		for (int i = 0; i < 20; i++) {

			String value = (int) (Math.random() * 10 + 1) + "," + (int) (Math.random() * 10 + 1);

			if (!checkDuplicates(value, getShips())) {
				getShips()[i] = value;
			} else {
				i--;
			}

		}
	}

	/**
	 * Checking if there is a duplicates in the given array
	 * 
	 * @param value
	 * @param array
	 * @return true if there is duplicate, false if there in none
	 */
	private boolean checkDuplicates(String value, String[] array) {

		for (int i = 0; i < array.length; i++) {
			if (value.equals(array[i]) && array[i] != null) {
				return true;
			}
		}
		return false;
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

	public String[] getShips() {
		return ships;
	}

	public void setShips(String[] ships) {
		this.ships = ships;
	}

}