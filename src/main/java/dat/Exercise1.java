package dat;

import java.util.Arrays;

public class Exercise1
{
    @FunctionalInterface
    public interface ArithmeticOperation
    {
        int perform(int a, int b);
    }

    public static void main(String[] args)
    {
        ArithmeticOperation addition = (x, y) -> x + y;
        ArithmeticOperation subtraction = (x, y) -> x - y;
        ArithmeticOperation multiplication = (x, y) -> x * y;
        ArithmeticOperation division = (x, y) -> {
            if (y == 0)
            {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return x / y;
        };
        ArithmeticOperation modulo = (x, y) -> x % y;
        ArithmeticOperation power = (x, y) -> (int) Math.pow(x, y);

        System.out.println(addition.perform(1, 2));
        System.out.println(multiplication.perform(2,3));
        System.out.println(subtraction.perform(10,3));
        System.out.println(division.perform(10,2));
        System.out.println(modulo.perform(100,3));
        System.out.println(power.perform(2,8));

        // Testing the operate method

        System.out.println(operate(18, 28, addition));
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        int[] result = operate(a, b, multiplication);
        System.out.println(Arrays.toString(result));
    }

    static int operate(int a, int b, ArithmeticOperation operation)
    {
        return operation.perform(a, b);
    }

    static int[] operate(int[] a, int[] b, ArithmeticOperation op)
    {
        if (a.length != b.length)
        {
            throw new IllegalArgumentException("Arrays must be of equal length");
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++)
        {
            result[i] = op.perform(a[i], b[i]);
        }
        return result;
    }
}
