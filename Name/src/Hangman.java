import java.util.HashMap;
import java.util.Scanner;
public class Hangman{

	private static String[] words = {"lucky", "goat", "link", "shepard", "switch", "serialization", "smoke", "oink", "will", "time", "drink", "quesadilla", "hamburger", "cheeseburger", "hack", "ultimate", "sephiroth", "kazuya", "bowser", "console", "father", "enter", "cowboy", "forget", "visitation", "amazement", "stakeholder", "speak", "miss", "shorter", "shower", "impact", "storytelling", "yourself"};
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;
	private static HashMap<Integer, String> dude = new HashMap<Integer, String>();
	private static String guesses = "";
	private static Integer guesstot = 0;
	private static Integer guessrem = 7;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		dude.put(0,"___|___" );
		dude.put(1,"   |" );
		dude.put(2,"   ____________" );
		dude.put(3,"   |          _|_" );
		dude.put(4,"   |         /   \\" );
		dude.put(5,"   |        |     |");
		dude.put(6,"   |         \\_ _/");
		dude.put(7,"   |           |" );
		dude.put(8,"   |          / \\ " );
		dude.put(9,"___|___      /   \\");
		dude.put(10,"   |         / | \\");
		while (count < 7 && asterisk.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(asterisk);
			String guess = scan.nextLine();
			guess = inputStr(guess);
			hang(guess);
			guesses += guess;
			System.out.println(guesstot + " letters guessed: " + guesses);
			System.out.println("Incorrect guesses remaining: " + guessrem);
		}
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static String inputStr (String input) {
		Scanner scan = new Scanner(System.in);
		while (true) {
		  try {
			if (input.length() == 1 && isNumeric(input) == false && !(guesses.contains(input))){
				return input;
			}
		  else{
			throw new Exception("String is not a single letter");
		  }
		}  catch (Exception e) {
			System.out.print ("Please enter a single unused letter: ");
			return inputStr(scan.nextLine());
		}
	  }
	}

	public static void hang(String guess) {
		guesstot++;
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			guessrem--;
			hangmanImage();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! You found the word " + word + " in " + guesstot + " guesses!");
		}
	}

	public static void hangmanImage() {
		switch(count){
		case 1:
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(dude.get(0));
			System.out.println();
			break;
		case 2:
			System.out.println("Wrong guess, try again");
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(0));
			break;
		case 3:
			System.out.println("Wrong guess, try again");
			System.out.println(dude.get(2));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(0));
			break;
		case 4:
			System.out.println("Wrong guess, try again");
			System.out.println(dude.get(2));
			System.out.println(dude.get(3));
			System.out.println(dude.get(4));
			System.out.println(dude.get(5));
			System.out.println(dude.get(6));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(1));
			System.out.println(dude.get(0));
			break;
		case 5:
			System.out.println("Wrong guess, try again");
			System.out.println(dude.get(2));
			System.out.println(dude.get(3));
			System.out.println(dude.get(4));
			System.out.println(dude.get(5));
			System.out.println(dude.get(6));
			System.out.println(dude.get(7));
			System.out.println(dude.get(7));
			System.out.println(dude.get(1));
			System.out.println(dude.get(0));
			break;
		case 6:
			System.out.println("Wrong guess, try again");
			System.out.println(dude.get(2));
			System.out.println(dude.get(3));
			System.out.println(dude.get(4));
			System.out.println(dude.get(5));
			System.out.println(dude.get(6));
			System.out.println(dude.get(7));
			System.out.println(dude.get(7));
			System.out.println(dude.get(8));
			System.out.println(dude.get(9));
			break;
		case 7:
			System.out.println("GAME OVER!");
			System.out.println(dude.get(2));
			System.out.println(dude.get(3));
			System.out.println(dude.get(4));
			System.out.println(dude.get(5));
			System.out.println(dude.get(6));
			System.out.println(dude.get(3));
			System.out.println(dude.get(10));
			System.out.println(dude.get(8));
			System.out.println(dude.get(9));
			System.out.println("GAME OVER! The word was " + word);
			break;
		default:
			break;
		}
	}
}