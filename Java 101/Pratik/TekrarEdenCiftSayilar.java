import java.util.HashSet;
import java.util.Set;

public class TekrarEdenCiftSayilar {

    public static void main(String[] args) {
        Set<Integer> occurrence = new HashSet<>();
        int[] numbers = {
                10, 46, 67, 3, 14, 53, 10, 78, 3, 88, 6, 62, 17, 48, 6, 33, 90, 77, 22, 95, 8, 46, 4, 4
        };

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j] && numbers[i] % 2 == 0) {
                    occurrence.add(numbers[i]);
                }
            }
        }

        System.out.println("Repeating even numbers: " + occurrence);

    }

}