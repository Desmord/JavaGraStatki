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

		// zrobic sprawdzanie poprawnosci wprowadzanych danych
		// sprawdzanie liter za drugim razem
		
		
		// pranie
		// karteczka
		// klawiatura kupic

		while (firstGame.getShipNumbersLeft() > 0) {

			firstGame.printGameBoard();
			System.out.print("\n");

			System.out.print("Podaj wspó³rzêdn¹ x: ");
			int x = sc.nextInt();
			sc.nextLine();

			System.out.print("Podaj wspó³rzêdn¹ y: ");
			int y = sc.nextInt();
			sc.nextLine();

			firstGame.shot(x, y);

		}

		System.out.println("Gartulacje. Zatopiono wszystkie statki po "+firstGame.getShotsNumber()+ " strza³ach.");

	}
}
