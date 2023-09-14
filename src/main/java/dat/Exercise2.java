package dat;

import java.util.Arrays;

public class Exercise2
{
    @FunctionalInterface
    interface MyTransformingType {
        int transform(int value);
    }

    @FunctionalInterface
    interface MyValidatingType {
        boolean isValid(int value);
    }

    public static void main(String[] args)
    {
        // Testing the map method
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(printArray(a));
        int[] tripled = map(a, x -> x * 3);
        System.out.println(printArray(tripled));


        // Testing the filter method
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = filter(b, x -> x % 2 == 0);
        System.out.println(printArray(evens));
    }

    // The map method takes an array of integers and a MyTransformingType
    public static int[] map(int[] a, MyTransformingType op)
    {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++)
        {
            result[i] = op.transform(a[i]);
        }
        return result;
    }

    public static int[] filter(int[] a, MyValidatingType op)
    {
        int filtersize = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (op.isValid(a[i]))
            {
                filtersize++;
            }
        }
        int[] result = new int[filtersize];

        int filterindex = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (op.isValid(a[i]))
            {
                result[filterindex] = a[i];
                filterindex++;
            }
        }
        return result;
    }

    static String printArray(int[] a)
    {
        return Arrays.toString(a);
    }
}
