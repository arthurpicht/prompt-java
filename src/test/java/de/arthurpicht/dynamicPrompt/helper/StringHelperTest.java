package de.arthurpicht.dynamicPrompt.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class StringHelperTest {

    @Test
    void plausibility1() {
        assertEquals("Test", StringHelper.getLastWord("Dies ist ein Test"));
        assertEquals("Test", StringHelper.getLastWord("Test"));
        assertEquals("Test", StringHelper.getLastWord(" Test"));
        assertEquals("Test", StringHelper.getLastWord("Test   "));
    }

    @Test
    void empty_neg() {
        try {
            StringHelper.getLastWord("");
            fail(IllegalArgumentException.class.getSimpleName() + "expected.");
        } catch (IllegalArgumentException e) {
            // din
        }
    }

    @Test
    void null_neg() {
        try {
            StringHelper.getLastWord(null);
            fail(IllegalArgumentException.class.getSimpleName() + "expected.");
        } catch (IllegalArgumentException e) {
            // din
        }
    }

    @Test
    void whiteSpace_neg() {
        try {
            StringHelper.getLastWord("");
            fail(IllegalArgumentException.class.getSimpleName() + "expected.");
        } catch (IllegalArgumentException e) {
            // din
        }
    }


}