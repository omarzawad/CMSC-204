package MorseCode1;

import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter
/**
 * @author Omar Mahmud
 */
{
	// Instance of the MorseCodeTree class, which will be used to perform the morse
	// code translation
	private static MorseCodeTree t = new MorseCodeTree();

	public MorseCodeConverter() {

	}

	public static java.lang.String convertToEnglish(java.lang.String code) {
		String output = "";
		String[] word; // will hold each singular word from
		String[] letter; // will hold each singular word from

		// split each word in the current line into a new array.
		word = code.split(" / ");

		// loop through the array containing all the words of a line
		for (int i = 0; i < word.length; i++) {
			// System.out.print(word[i]);

			// split each letter in the current word into a new array.
			letter = word[i].split(" ");

			for (int j = 0; j < letter.length; j++) {
				// System.out.println(letter[j]);

				output += t.fetch(letter[j]);
			}

			// add a space after each word has been translated
			output += " ";
		}

		// take off preceeding or succedding spaces
		output = output.trim();

		return output;
	}

	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException {
		String output = "";
		ArrayList<String> line = new ArrayList<String>();
		String[] word; // will hold each singular word from
		String[] letter; // will hold each singular word from

		Scanner inputFile;
		inputFile = new Scanner(codeFile);

		// Read each content, line by line from the .txt file into a String ArrayList
		while (inputFile.hasNext()) {
			line.add(inputFile.nextLine());
		}

		inputFile.close();

		// loop through the ArrayList containing all the lines
		for (int i = 0; i < line.size(); i++) {
			// System.out.print(line.get(i));

			// split each word in the current line into a new array.
			word = line.get(i).split(" / ");

			// loop through the array containing all the words of a line
			for (int j = 0; j < word.length; j++) {

				// System.out.print(word[j]);

				// split each letter in the current word into a new array.
				letter = word[j].split(" ");

				for (int k = 0; k < letter.length; k++) {
					// System.out.println(word[j]);

					output += t.fetch(letter[k]);
				}

				// add a space after each word has been translated
				output += " ";
			}
		}
		// take off preceeding or succedding spaces
		output = output.trim();

		return output;
	}

	public static java.lang.String printTree() {
		ArrayList<String> treeData = new ArrayList<String>();

		treeData = t.toArrayList();

		String print = "";

		for (int i = 0; i < treeData.size(); i++) {
			print += treeData.get(i) + " ";
		}

		return print;
	}
}