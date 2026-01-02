import java.util.Scanner;
public class SentenceFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph to format:");
        String inputParagraph = scanner.nextLine();

        String formattedParagraph = formatParagraph(inputParagraph);
        System.out.println("Formatted Paragraph:");
        System.out.println(formattedParagraph);

        scanner.close();
    }

    // Method to format the paragraph
    public static String formatParagraph(String paragraph) {
        // Trim extra spaces
        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        // Capitalize first letter of each sentence and ensure one space after punctuation
        StringBuilder formatted = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < paragraph.length(); i++) {
            char currentChar = paragraph.charAt(i);

            if (capitalizeNext && Character.isLetter(currentChar)) {
                formatted.append(Character.toUpperCase(currentChar));
                capitalizeNext = false;
            } else {
                formatted.append(currentChar);
            }

            if (currentChar == '.' || currentChar == '?' || currentChar == '!') {
                capitalizeNext = true;
                // Ensure one space after punctuation
                if (i + 1 < paragraph.length() && paragraph.charAt(i + 1) != ' ') {
                    formatted.append(' ');
                }
            }
        }

        return formatted.toString().trim();
    }
}
