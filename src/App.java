
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
			{ "1  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "X ", "- " },
			{ "2  ", "X ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "X ", "- " },
			{ "3  ", "X ", "- ", "- ", "- ", "- ", "X ", "X ", "- ", "X ", "- " },
			{ "4  ", "X ", "- ", "- ", "X ", "- ", "- ", "- ", "- ", "X ", "- " },
			{ "5  ", "- ", "- ", "- ", "- ", "X ", "- ", "- ", "- ", "X ", "- " },
			{ "6  ", "- ", "- ", "- ", "- ", "- ", "X ", "- ", "- ", "- ", "- " },
			{ "7  ", "- ", "- ", "- ", "- ", "- ", "- ", "X ", "- ", "- ", "- " },
			{ "8  ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " },
			{ "9  ", "- ", "X ", "X ", "X ", "X ", "- ", "- ", "- ", "X ", "X " },
			{ "10 ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- ", "- " }, };

	public Game() {
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

	public String[][] getGameBoard() {
		return gameBoard;
	}

}