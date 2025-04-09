package regex;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://website-lab.ru/article/regexp/shpargalka_po_regulyarnyim_vyirajeniyam/
 */
public class RegexTest {
    @Test
    public void notDigitAndChars() {
        String pure = "1234abcdefg";
        String s = "1/2.3,4'a]b[cde;f+g";

//        String regex = "[^\\daA-zZ]";
        String regex = "[^\\w]";
        String res = s.replaceAll(regex, "");
        Assert.assertEquals(pure, res);
    }
}
