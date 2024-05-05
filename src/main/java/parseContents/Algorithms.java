package parseContents;

public class Algorithms {

    public static void parseContents(String s) {
        // Use forEach loop and convert into character array
        System.out.println("Option 1");
        for (char c: s.toCharArray()) {
            System.out.print(c);
        }

        System.out.println();
        System.out.println("Option 2");
        // Use a regular for loop
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c);
        }
    }

    // Applying custom parsing to search algorithms
    public static boolean isAtEvenIndex(String s, char item) {
        // Add base case to catch nul
        if (s == null || s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length() / 2 + 1; i=i+2) {
            // cuts time complexity in half, skip over odd indices
            if (s.charAt(i) == item) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "HeLLo";
        System.out.println(s.contains("LL"));

        parseContents(s);
        System.out.println();

        System.out.println(isAtEvenIndex(s, 'L'));
        System.out.println(isAtEvenIndex(s, 'T'));
        System.out.println(isAtEvenIndex(s, 'H'));
        System.out.println(isAtEvenIndex("", 'H'));
        System.out.println(isAtEvenIndex(null, 'H'));
    }

}
