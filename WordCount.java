import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        // Prompt the user to enter a text or provide a file
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text or file path: ");
        String input = scanner.nextLine();

        // Read the input text or file and store it in a string
        String text;
        if (input.endsWith(".txt")) {
            try {
                text = readFile(input);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            text = input;
        }

        // Split the string into an array of words using space or punctuation as delimiters
        String[] words = text.split("[\\p{Punct}\\s]+");

        // Initialize a counter variable to keep track of the number of words
        int count = 0;

        // Iterate through the array of words and increment the counter for each word encountered
        for (String word : words) {
            if (!word.isEmpty()) { // Skip empty words
                count++;
            }
        }

        // Display the total count of words to the user
        System.out.println("Total word count: " + count);
    }

    // Read the contents of a file and return as a string
    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return content.toString();
    }
}
