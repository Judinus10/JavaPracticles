package Arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class removeDuplicate {
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>(); // Preserves order
        for (int num : arr) {
            set.add(num);
        }

        // Convert Set to array
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 4, 4, 5};
        int[] output = removeDuplicates(input);

        System.out.println(Arrays.toString(output)); // Output: [1, 2, 3, 4, 5]
    }
}
