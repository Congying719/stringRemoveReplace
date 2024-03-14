package org.sys;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReplaceStrAlgorithmTest {

    ReplaceStrAlgorithm rep = new ReplaceStrAlgorithm();

    @Test
    public void removeConsecutiveStr() {
        assertEquals("d",rep.removeConsecutiveStr("aabcccbbad"));
        assertEquals("",rep.removeConsecutiveStr("aaabccdddcbb"));
        assertEquals("",rep.removeConsecutiveStr(""));
    }

    @Test
    public void replaceConsecutiveChars() {
        assertEquals("d",rep.replaceConsecutiveChars("abcccbad"));
        assertEquals("awb",rep.replaceConsecutiveChars("cccbbxzzzyyxcdddc"));
        assertEquals("",rep.replaceConsecutiveChars("aaabcdddcbbaa"));
        assertEquals("",rep.replaceConsecutiveChars(""));

    }

    @Test
    public void preChar() {
        assertEquals("",rep.preChar('a'));
        assertEquals("a",rep.preChar('b'));

    }
}