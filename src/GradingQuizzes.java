
// ****************************************************************
// GradingQuizzes.java
//
// Reads in and stores a key of correct answers.  Compares the key
// to imported answers and returns amount of correct answers
// ****************************************************************

import java.util.*;

public class GradingQuizzes {
	private static Scanner in = new Scanner(System.in);
	private static char[] key;
	private static char[] quiz;
	private static boolean grading = true;
	private static int questions;

	public static void main(String[] args) {
		ReadKey();
		while (grading) {
			ReadQuiz();
			Grade();
		}
	}

	public static void ReadKey() {
		System.out.println("How many questions are there?");
		questions = in.nextInt();// reads the number of questions
		in.nextLine();// moves the pointer to the next line
		key = new char[questions];// creates the key array
		System.out.println("Please enter the key on one line");
		String longKey = in.nextLine();// reads in the key into a string
		for (int i = 0; i < questions; i++) {
			key[i] = longKey.toUpperCase().charAt(i);
			// pieces apart the string into chars and puts them each into an
			// array
		}
	}

	public static void ReadQuiz() {
		quiz = new char[key.length];
		System.out.println("Please enter the quiz answers on one line");
		String longQuiz = in.nextLine();// reads in the quiz answers
		for (int i = 0; i < key.length; i++) {
			quiz[i] = longQuiz.toUpperCase().charAt(i);
			// pieces apart the string into chars and puts them each into an
			// array
		}
	}

	public static void Grade() {
		int correct = 0;// for printing and adding at the end
		// printing answers with a little formatting
		System.out.println("\n   Q#   Key   Quiz   Correct");
		System.out.println("---------------------------------");
		for (int i = 0; i < key.length; i++) {
			if (key[i] == quiz[i]) {
				System.out.println("   " + i + "     " + key[i] + "       " + quiz[i] + "        " + "Yes");
				correct++;
			} else {
				System.out.println("   " + i + "     " + key[i] + "       " + quiz[i] + "        " + "No");
			}
		}
		System.out.println("\nTotal Score: " + correct + "/" + questions);
		float percentage = (float) correct / questions;// adds up percentage
		System.out.println("Percent Grade: %" + percentage);
		System.out.println("\nWould you like to grade another? (Y/N)");
		char answer = in.nextLine().toUpperCase().charAt(0);// reads in answer
		if (answer == 'N') {
			grading = false;// breaks the loops and exits
		}
	}
}
