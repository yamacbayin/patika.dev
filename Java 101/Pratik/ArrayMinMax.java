public class ArrayMinMax {

    public static void main(String[] args) {
        int[] list = {56, 34, 1, 8, 101, -2, -33};

        int min = list[0];
        int min2 = Integer.MAX_VALUE;
        int max = list[0];
        int max2 = Integer.MIN_VALUE;

        for (int i : list) {
            if (i < min) {
                min2 = min;
                min = i;
            }
            if (i > max) {
                max2 = max;
                max = i;
            }
        }

        System.out.println("Minimum Değer " + min);
        System.out.println("Maximum Değer " + max);
        System.out.println("Minimum2 Değer " + min2);
        System.out.println("Maximum2 Değer " + max2);

    }

}