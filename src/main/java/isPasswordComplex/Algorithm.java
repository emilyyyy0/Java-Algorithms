package isPasswordComplex;

public class Algorithm {
    // Check if password has specific properties
    public static boolean isPasswordComplex(String s) {
        return s.chars().anyMatch(Character::isUpperCase) &&
                s.chars().anyMatch(Character::isLowerCase) &&
                s.chars().anyMatch(Character::isDigit);

        // Can also create a lambda function
        // In this, only one of the condition has to be true for one character in the string.
//        s.chars().anyMatch(c -> Character.isUpperCase(c) ||
//                    Character.isLowerCase(c) || Character.isDigit(c));

    }
    public static void main(String[] args) {
        System.out.println(isPasswordComplex("Hell0"));
        System.out.println(isPasswordComplex("Hello"));
        System.out.println(isPasswordComplex("hellO"));
        System.out.println(isPasswordComplex("HeLLo"));
        System.out.println(isPasswordComplex("hello"));
        System.out.println(isPasswordComplex(" "));
    }
}
