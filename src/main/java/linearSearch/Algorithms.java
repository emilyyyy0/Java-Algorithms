package linearSearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class Algorithms {

    public static boolean linearSearch(int[] arr, int item) {
        for (int current : arr) {
            if (current == item) {
                return true;
            }
        }
        return false;
    }

    public static int linearSearchValue (int[] arr, int item) {
        for (int current : arr) {
            if (current == item) {
                return item;
            }
        }
        return -1; // or null but need to make the return type Integer not int
    }

    public static OptionalInt linearSearch2(int[] arr, int item) {
        return Arrays.stream(arr).filter(x -> x == item).findFirst();
        // findFirst(): If at least one item meets the condition, it returns an OptionalInt
        // Optional acts as a container object to help prevent null exceptions

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(linearSearch(arr, 1));
        System.out.println(linearSearchValue(arr, 8));
        linearSearch2(arr, 1).ifPresent(System.out::println); // if optional is present, item does exist in the array, print it out.
        linearSearch2(arr, 8).ifPresent(System.out::println);
    }

}
