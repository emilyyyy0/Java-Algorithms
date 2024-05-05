package buildStrings;

public class Algorithms {

    public static String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        // Strings are immutable, use stringbuilder
        StringBuilder reversed = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }

    // Another way we can reverse the string, is by converting our data into a
    // datatype that has a build in reverse method.
    public static String reverse2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(null));
        System.out.println(reverse(""));
        System.out.println(reverse("hello"));
        System.out.println(reverse2("tacos"));
    }

}
