package dat;

import java.util.function.Function;

public class Util
{
    public static Function<String, String> replaceColon = str -> str.replace(":","=");
    public static Function<String, String> addBraces = str -> "{" + str + "}";
}
