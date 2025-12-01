// Problem number: 27
import java.util.HashMap;
import java.util.Map;

public class NoOfSubarraysK {
    public static int bruteForce(int[] array, int k) {
        int n = array.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum = sum + array[m];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int better(int[] array, int k) {
        int n = array.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + array[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int optimal(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;
            int need = prefix - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(bruteForce(array, k));
        System.out.println(better(array, k));
        System.out.println(optimal(array,k));
    }
}



