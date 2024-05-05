package normaliseData;

public class Algorithms {

    public static String normaliseString(String s) {
//        String lowercased = s.toLowerCase();  // new piece of data
//        String trimmed = lowercased.trim(); // remove trailing whilespaces at end of input data
//        // If there are certain characters we don't want to consider, use replace
//        String normalized = trimmed.replace(",", "");

        // Now we put it into one line
        return s.toLowerCase().trim().replace(",","");
    }

    public static void main(String[] args) {
        System.out.println(normaliseString("    Hello There, BUDDY   "));
    }
}
