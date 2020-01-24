import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
/**
 * The Hangman class is what plays the hangman game and tracks the win loss record of the player and whether or not the player wants to play again.
 * @author Austin Bradburn
 *@version 1.0
 *Hangman Project
 *Spring 2020
 */
public class Hangman {
	
	private int wins; //wins is used to track the number of wins the player has total.
	private int losses; //losses is used to track the number of losses the player has total.
	private String currentWord; //currentWord is the word that the current game is using for the player to guess.
	private Dictionary dictionary; //dictionary is what is used to call the dictionary.txt text file to load the words into the game.
	
	/**
	 * The empty argument constructor initializes the instance variables.
	 */
	
	public Hangman() {
		wins=0;
		losses=0;
		currentWord="";
	}//Closes Hangman
	
	/**
	 * @param wins is the number of wins the player has.
	 * @param losses is the number of losses the player has.
	 * @param currentWord is the current word that the player is trying to guess.
	 * @throws FileNotFoundException
	 */
	
	private void loadWL() throws FileNotFoundException {
		File file=new File("wlrecord.txt");
		Scanner fileScan= new Scanner(file);
			this.wins=Integer.parseInt(fileScan.next());
			this.losses=Integer.parseInt(fileScan.next());
		fileScan.close();
	}//Closes loadWL
	
	/**
	 * loadWL loads the wlrecord.txt file and adds the total wins and losses into the game from the file.
	 * @throws IOException
	 */
	
		private void writeWL() throws IOException {
			BufferedWriter writer = new BufferedWriter(new FileWriter("wlrecord.txt"));
			writer.write(Integer.toString(wins)+"\n");
			writer.write(Integer.toString(losses));
			writer.close();
		}//Closes writeWL
		
		/**
		 * writeWL accesses the wlrecord.txt text file and writes the additional wins and losses into the file before saving it over the old file.
		 * @throws IOException
		 */
		
	public void playGame() throws IOException {
		int currentWins=0; //currentWins is the number of wins the player has in this session.
		int currentLosses=0; //currentLosses is the number of losses the player has in this session.
		this.loadWL();
		Dictionary dictionary=new Dictionary("dictionary.txt");
		String temp; //The temp string is used to determine if the player wants to continue playing or not.
		Scanner scan=new Scanner(System.in);
		System.out.print("Would you like to play a game? Y/N ");
		temp=scan.nextLine();
			while(temp.contentEquals("Y")) {
				currentWord=dictionary.chooseWord();
				int guesses=5; //The int guesses records the number of guesses the player has left.
				String guess=""; //The String guess is the character that the player input as a guess.
				String letters=""; //The string letters are the characters that have been revealed that the player has guessed.
				boolean finished = false; //finished determines whether or not the player has finished the game or not.
				boolean correctGuess; //boolean correctGuess determines if the player guesses a correct letter or not.
				for(int i=0; i<currentWord.length(); i++) {
					letters=letters+"_";
				}//ends the for loop
				
				/**
				 * This section of the playGame method opens up the wins and losses and calls the dictionary class to select a new random word.
				 * The class asks the player if they want to play and if they answer yes it selects a word and then creates a pattern of underscores and spaces based on the length of the word chosen.
				 */
				
					while(guesses>0) {
						finished=true;
						correctGuess=false;
						System.out.println("You have "+guesses+" remaining guesses");
						for(int i=0; i<letters.length(); i++) {
							System.out.print(letters.charAt(i)+" ");
						}//Closes for
						
						/**
						 * This section of the code determines if the player has any guesses left and if they do they allow the player to keep guessing.
						 */
						
						System.out.println("");
						System.out.print("What is your guess?");
							guess=scan.nextLine();
							String newLetters="";
								for(int i=0; i<letters.length(); i++) {
									if(letters.charAt(i)!='_') {
										newLetters=newLetters+letters.charAt(i);
									}else if(guess.charAt(0)==currentWord.charAt(i)){
										newLetters=newLetters+currentWord.charAt(i);
										correctGuess=true;
									}else {
										newLetters=newLetters+"_";
										finished=false;
									}//closes else
								}//Closes for
								
								/**
								 * This section of the code asks what your guess is and uses a for loop to determine if the letter guessed matches any of the letters used in the chosenWord.
								 * @return correctGuess
								 * @return finished
								 */
								
							letters=newLetters;
							if(correctGuess==false) {
								guesses--;
							}//Closes if
							if(finished==true)	{
								guesses=0;
							}//Closes if
					}//Closes while
					
					/**
					 * if the letter guessed is incorrect then the total number of guesses the player has is decreased by one. If the player has finished the game then the number of guesses is set to 0.
					 */
					
				System.out.println("The finished word was "+currentWord);
				if(finished==true) {
					System.out.println("You won!");
					currentWins++;
					wins++;
				}else {
					System.out.println("You are out of guesses! You lost!");
					currentLosses++;
					losses++;
				}//Closes else
				System.out.println("You had "+currentWins+" wins and "+currentLosses+" losses this round.");
				System.out.println("You have a total of "+wins+" wins and " +losses+" losses");
				this.writeWL();
				System.out.println("Would you like to play again? Y/N");
				temp=scan.nextLine();
		}//Closes while
			
			/**
			 * This section prints out what the current word was after the player has finished or run out of guesses.
			 * If the player has won then the total and session values for wins have been increased.
			 * If the player has lost then the total and session values of losses have been increased.
			 * The game then prints out each of the wins and loss amount for the game and asks if the player wants to play again.
			 * If the player wants to play again then it begins from the start, if the player chooses no then the game ends.
			 */
			
			System.out.println("Thanks for Playing!");
	}//Closes playGame

			// TODO Auto-generated method stub
			
		
}//Closes class Hangman