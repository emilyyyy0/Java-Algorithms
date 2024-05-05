package isUpper_isLower;

// Validation algorithm
public class Algorithm {

    // Check every character is uppercase
    public static boolean isUppercase(String s) {
        // Iterate through the string using streams
        return s.chars().allMatch(Character::isUpperCase);
    }

    // Check every character is lowercase
    public static boolean isLowercase(String s) {
        // s.chars().noneMatch(Character::isUpperCase);
        return s.chars().allMatch(Character::isLowerCase);
    }

    public static void main(String[] args) {
        System.out.println(isUppercase("hello"));
        System.out.println(isUppercase("HELLO"));

        System.out.println(isLowercase("hello"));
        System.out.println(isLowercase("HELLO"));
    }

}
