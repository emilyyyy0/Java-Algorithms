package rotateArray;

import java.util.Arrays;

public class Algorithms {
    // Develop an algorithm that rotates the contents of an array by one position
    // to the left. Each ite in the array will be moved one index to the left.
    // The one exception is for the first item in the array. Rotating the first
    // item to the left would mean moving it to an invalid index.
    // Instead, this item should be placed at the end of the array

    static int[] rotateArray(int[] numbers) {
        int[] rotated = new int[numbers.length];

        for (int i = 1; i < numbers.length; i++) {
            // copy elements from numbers array to the rotated array at one index to the left
            // rotate[0] = numbers[1]
            // rotate[1] = numbers[2]
            rotated[i-1] = numbers[i];
        }
        rotated[rotated.length - 1] = numbers[0];
        return rotated;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        Arrays.stream(rotateArray(arr)).forEach(System.out::println);
    }

}
