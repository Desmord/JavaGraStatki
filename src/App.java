import java.util.Scanner;

public class App {
	/**
	 * Function that starts the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Game firstGame = new Game();
		Scanner sc = new Scanner(System.in);

		System.out.println("Witaj w grze w statki.\n");

		// pranie
		// karteczka
		// klawiatura kupic

		// Do while the number of sunken ships is greater than 0
		while (firstGame.getShipNumbersLeft() > 0) {

			String x;
			char y;

			firstGame.printGameBoard();
			System.out.print("\n");

			do {

				System.out.print("Podaj wspó³rzêdn¹ x: ");
				x = sc.nextLine();

			} while (firstGame.checkIfNumberIsCorrect(x));

			do {

				System.out.print("Podaj wspó³rzêdn¹ y: ");
				y = sc.nextLine().charAt(0);

			} while (firstGame.checkIfLetterIsCorrect(y));

			firstGame.shot(Integer.parseInt(x), firstGame.returnNumberFromLetter(y));

		}

		System.out.println("Gartulacje. Zatopiono wszystkie statki po " + firstGame.getShotsNumber() + " strza³ach.");

	}
}
