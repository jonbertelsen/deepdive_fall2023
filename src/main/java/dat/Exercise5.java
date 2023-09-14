package dat;

import java.util.Arrays;

public class Exercise5
{
    @FunctionalInterface
    interface MyTransformingType {
        int transform(int value);
    }

    @FunctionalInterface
    interface MyValidatingType {
        boolean isValid(int value);
    }

    static int triple(int x)
    {
        return 3 * x;
    }

    static boolean even(int x)
    {
        return x % 2 == 0;
    }

    public static void main(String[] args)
    {
        // Testing the map method
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        int[] tripled = Exercise2.map(a, Exercise5::triple);
        System.out.println(Arrays.toString(tripled));


        // Testing the filter method
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = Exercise2.filter(b, Exercise5::even);
        System.out.println(Arrays.toString(evens));
    }

}
