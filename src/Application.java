import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class calls the Hangman class to begin playing the game
 * @author Austin bradburn
 * @version 1.0
 * Hangman Project
 * Spring 2020
 */
public class Application {
	public static void main(String[]args) throws IOException {
		Hangman hangman=new Hangman();
			hangman.playGame();
	}//Closes Main
	/**
	 * The Application class calls the playGame method in the Hangman class that will allow the game to be played.
	 */
}//Closes class Application