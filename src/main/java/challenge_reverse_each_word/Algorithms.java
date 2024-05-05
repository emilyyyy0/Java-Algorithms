package challenge_reverse_each_word;

public class Algorithms {

    private static String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    // Return a new String with each word reversed
    static String reverseEachWord2(String sentence) {
        // Your code goes here.
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }

            sb.append(reverse(words[i]));
        }
        sb.append(" ");
        return sb.toString();
    }

    // Return a new String with each word reversed
    static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String[] words = sentence.split(" ");

        for (String word : words) {
            result.append(reverse(word));
            result.append(" ");
        }
        result.trimToSize(); // Trims the spaces off the ends

        return result.toString();

    }


    public static void main(String[] args) {
        System.out.println(reverseEachWord("sally is a great worker"));
    }

}
