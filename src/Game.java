/**
 * Class respond for control and display game
 * 
 * @author Miko³aj Chojnacki
 *
 */
public class Game {

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
	private int shipNumbersLeft = 20;
	private String[] ships = new String[20];
	private String[] shipsSank = new String[20]; 

	public Game() {
		generateShips();
	}

	/**
	 * Function checks if the ship has been hit and updates the game boards
	 * 
	 * @param x
	 *            coordinates
	 * @param y
	 *            coordinates
	 */
	public void shot(int x, int y) {
		
		symulateClearConsole();

		String point = x + "," + y;
		Boolean hit = false;

		for (int i = 0; i < 20; i++) {

			if (point.equals(getShips()[i])) {

				setShipNumbersLeft(getShipNumbersLeft() - 1);

				hit = true;

				getGameBoard()[x][y] = "X ";

				System.out.println("Trafienie w punkcie x: " + x + " y: " + y + ".");
				System.out.println("Zosta³o " + getShipNumbersLeft() + " statków.\n");

			}
		}

		if (!hit) {

			getGameBoard()[x][y] = "o ";

			System.out.println("     Pud³o. \n");
		}

	}

	/**
	 * Simulates cleaning the console
	 */
	private void symulateClearConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
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
	 * @return true if there is duplicate in the array, false if there in none
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
	public void printGameBoard() {

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

	public String[] getShipsSank() {
		return shipsSank;
	}

	public void setShipsSank(String[] shipsSank) {
		this.shipsSank = shipsSank;
	}

}