import java.io.*;
import java.util.Scanner;
import java.security.SecureRandom;

/**
 * The dictionary class is where the dictionary.txt file is loaded into an array and a random place in the array is chosen to pick a word from the list.
 * @author Austin Bradburn
 *@version 1.0
 *Hangman Project
 *Spring 2020
 */

public class Dictionary {
	private String[] wordList; //wordList is the String Array that stores the list of words given.
	private SecureRandom randomNumbers; //randomNumbers uses seeds to select a random number from the list for the words used.
	
		public Dictionary(String filename) throws FileNotFoundException {
			this.wordList= new String[200];
			this.readFile(filename);
		}//ends Constructor
	public void readFile(String fileName) throws FileNotFoundException {
		File file=new File(fileName);
		Scanner fileScan= new Scanner(file);
		int x=0; //The int x is used to increment through the file to continue adding words from the document until all are entered.
		while(fileScan.hasNext()) {
			this.wordList[x]=fileScan.next();
			x++;
		}//ends While
		
		/**
		 * @param fileName is the String that loads the file and reads it.
		 */
		
	}//ends readFile
	public String chooseWord(){
	randomNumbers=new SecureRandom();
	return wordList[randomNumbers.nextInt(200)];
	}//Ends chooseWord
	
	/**
	 * This class creates an array with 200 spaces that the words from the dicitonary.txt file.
	 * After all of the words are loaded into the array randomNumbers is used to randomly select a number and use that number in the array to determine which word in the text file is going to be used for the hangman game.
	 * @return wordList
	 */
	
}//ends Class