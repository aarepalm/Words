import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Words {
	private static final String FILE = "article.txt";

	public static void main(String args[]) {
		String longestWord = new String();
		String shortestWord = new String();
		try {
			Scanner sc = new Scanner(new File(FILE));
			while (sc.hasNext()) {
				String lineOfWords[] = sc.nextLine().trim().split("[.,!?:;'\"-]|\\s+");
				for (String word : lineOfWords) {
					if (word.length() > longestWord.length()) {
						longestWord = word;
						continue;
					}
					if ((word.length() < shortestWord.length()) || (shortestWord.length() == 0)) {
						shortestWord = word;
					}
				}
			}
			System.out.println("Longest word is: " + longestWord);
			System.out.println("Shortest word is: " + shortestWord);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
