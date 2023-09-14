package dat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilTest
{
    @Test
    void replaceColonTest()
    {
        String input = "key:value";
        String expected = "key=value";
        String actual = Util.replaceColon.apply(input);
        assertEquals(expected, actual);
    }
}