import java.util.*;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {

            int lineStart = index;
            int lineLength = words[index].length();
            index++;

            // Fit maximum words in the current line
            while (index < words.length &&
                   lineLength + words[index].length() + (index - lineStart) <= maxWidth) {

                lineLength += words[index].length();
                index++;
            }

            int totalSpaces = maxWidth - lineLength;
            int numWords = index - lineStart;

            StringBuilder line = new StringBuilder(words[lineStart]);

            // Last line or single-word line
            if (numWords == 1 || index == words.length) {

                for (int i = lineStart + 1; i < index; i++) {
                    line.append(" ").append(words[i]);
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Distribute spaces between words
                int spacesBetweenWords = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int i = lineStart + 1; i < index; i++) {

                    int spaces = spacesBetweenWords;

                    if (extraSpaces > 0) {
                        spaces++;
                        extraSpaces--;
                    }

                    line.append(" ".repeat(spaces));
                    line.append(words[i]);
                }
            }

            result.add(line.toString());
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words = {
            "This", "is", "an", "example",
            "of", "text", "justification."
        };

        int maxWidth = 16;

        List<String> result = fullJustify(words, maxWidth);

        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }
}