/**
 * Class respond for control and display game
 * 
 * @author Miko�aj Chojnacki
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
	private int shotsNumber = 0;
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

		String point = x + "," + y;
		Boolean hit = false;

		symulateClearConsole();

		setShotsNumber(getShotsNumber() + 1);
		System.out.println("Wystrzelono " + getShotsNumber() + " pocisk�w.");

		for (int i = 0; i < 20; i++) {

			if (point.equals(getShips()[i])) {

				if (checkIfShipAlreadyHit(point)) {

					setShipNumbersLeft(getShipNumbersLeft() - 1);

					hit = true;

					getGameBoard()[x][y] = "X ";

					System.out.println("Trafienie w punkcie x: " + x + " y: " + y + ".");
					System.out.println("Zosta�o " + getShipNumbersLeft() + " statk�w.\n");

				}
			}
		}

		if (!hit) {

			if (checkIfShipAlreadyHit(point)) {
				getGameBoard()[x][y] = "o ";
			} else {
				System.out.println("Statek zosta� ju� zatopiony.");
			}

			System.out.println("          Pud�o. \n");
		}

	}

	/**
	 * Checks if ships was already hit
	 * 
	 * @param point
	 * @return true if not already hit
	 */
	private boolean checkIfShipAlreadyHit(String point) {

		for (int i = 0; i < 20; i++) {
			if (point.equals(getShipsSank()[i])) {

				return false;

			}
		}

		getShipsSank()[getShipNumbersLeft() - 1] = point;

		return true;

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

			if (!checkShipsDuplicates(value, getShips())) {
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
	private boolean checkShipsDuplicates(String value, String[] array) {

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

	/**
	 * Checks if given number is form 1 to 10
	 * 
	 * @param number
	 * @return false if is form 1 to 10
	 */
	public boolean checkIfNumberIsCorrect(String number) {

		try {
			if (Integer.parseInt(number) > 0 && Integer.parseInt(number) < 11) {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("�le wprowadzone dane. \nMusi by� liczba z przedzia�u 1-10");
		}

		System.out.println("Liczba z poza zakresu 1-10");
		return true;
	}

	/**
	 * Checks if given letter is form A to J
	 * 
	 * @param number
	 * @return false if is form 1 to 10
	 */
	public boolean checkIfLetterIsCorrect(char letter) {

		char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

		try {

			for (int i = 0; i < letters.length; i++) {

				if (Character.toUpperCase(letter) == letters[i]) {
					return false;
				}

			}

		} catch (Exception ex) {
			System.out.println("�le wprowadzone dane. \nMusi by� litera z przedzia�u A-J.");
		}

		System.out.println("�le wprowadzone dane. \nMusi by� litera z przedzia�u A-J.");
		return true;
	}

	/**
	 * Return number depending on what letter was given
	 * 
	 * @param letter
	 * @return number
	 */
	public int returnNumberFromLetter(char letter) {

		switch (Character.toUpperCase(letter)) {
		case 'A':
			return 1;
		case 'B':
			return 2;
		case 'C':
			return 3;
		case 'D':
			return 4;
		case 'E':
			return 5;
		case 'F':
			return 6;
		case 'G':
			return 7;
		case 'H':
			return 8;
		case 'I':
			return 9;
		case 'J':
			return 10;
		default:
			return 1;
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

	public int getShotsNumber() {
		return shotsNumber;
	}

	public void setShotsNumber(int shotsNumber) {
		this.shotsNumber = shotsNumber;
	}

}