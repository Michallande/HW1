import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        // 1. תקינות כיוון
        if (direction != 'R' && direction != 'L') {
            return array;
        }

        // 2. תקינות מערך ריק - מחזירים את array
        if (array.length == 0) {
            return array;
        }

        // 3. הפיכת move שלילי לחיובי והפיכת הכיוון בהתאם
        if (move < 0) {
            move = -move;
            if (direction == 'R') {
                direction = 'L';
            } else {
                direction = 'R';
            }
        }

        int n = array.length;
        int steps = move % n;
        int[] helper = new int[n];

        // 4. הזזה מעגלית: פלוס לימין, מינוס לשמאל
        for (int i = 0; i < n; i++) {
            if (direction == 'R') {
                helper[(i + steps) % n] = array[i];
            } else {
                helper[(i - steps + n) % n] = array[i];
            }
        }

        // 5. העתקה בחזרה למערך המקורי
        for (int i = 0; i < n; i++) {
            array[i] = helper[i];
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}