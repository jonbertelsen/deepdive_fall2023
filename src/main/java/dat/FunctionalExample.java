package dat;

import java.util.function.Function;

public class FunctionalExample
{
    // key:value => {key=value}

    public static void main(String[] args)
    {
        String input = "key:value";
        String withEqual = input.replace(":","=");
        String braces = "{" + withEqual + "}";
        System.out.println(braces);


        String result = Util.replaceColon
                            .andThen(Util.addBraces)
                            .apply(input);

        result = Util.addBraces.compose(Util.replaceColon).apply(input);

        System.out.println(result);



    }

}
