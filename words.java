import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Words {
	private static final String FILE = "article.txt";

	public static void main(String args[]) {
		ArrayList<String> longestWords = new ArrayList<String>();
		ArrayList<String> shortestWords = new ArrayList<String>();
		int lengthOfLongest = 0;
		int lengthOfShortest = 0;
		try {
			Scanner sc = new Scanner(new File(FILE));
			while (sc.hasNext()) {
				String lineOfWords[] = sc.nextLine().trim().split("[.,!?:;'\"-]|\\s+");
				for (String word : lineOfWords) {
					// This is done only on first iteration
					if (shortestWords.size() == 0) {
						shortestWords.add(word);
						lengthOfShortest = word.length();
					}
					if (word.length() >= lengthOfLongest) {
						// In case of strictly longer then reset the contanainer and the lenght variable
						if (word.length() > lengthOfLongest) {
							longestWords.clear();
							lengthOfLongest = word.length();
						}
						longestWords.add(word);
					}
					if (word.length() <= lengthOfShortest) {
						// In case of strictly shorter then reset the contanainer and the lenght variable
						if (word.length() < lengthOfShortest) {
							shortestWords.clear();
							lengthOfShortest = word.length();
						}
						shortestWords.add(word);
					}
				}
			}
			System.out.print("Longest words are: ");
			for (String word : longestWords)
				System.out.print(word + " ");

			// New line for output
			System.out.println();

			System.out.print("Shortest words are: ");
			for (String word : shortestWords)
				System.out.print(word + " ");

			// New line for output
			System.out.println();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
