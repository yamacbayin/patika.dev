import java.util.HashMap;
import java.util.Map;

public class ArrayTekrarEdenElemenalar {

    public static void main(String[] args) {

        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};

        Map<Integer, Integer> map = new HashMap<>();

        for (int number : array) {
            if (map.containsKey(number)) {
                int count = map.get(number);
                ++count;
                map.put(number, count);
            } else {
                map.put(number, 1);
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + " sayısı " + map.get(key) + " kez tekrar edildi.");
        }

    }

}