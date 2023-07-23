package cn.topicstudy.jutil.basic.text;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdUtilTest {
    @Test
    public void uniqueString() {
        assertEquals(IdUtil.uniqueString(10).length(), 10);
    }

    @Test
    public void uuid() {
        String uuid = IdUtil.uuid();
        // System.out.println(uuid);
        assertTrue(uuid.contains("-"));
    }

    @Test
    public void uuidWithoutLine() {
        String uuid = IdUtil.uuidWithoutLine();
        // System.out.println(uuid);
        assertFalse(uuid.contains("-"));
    }
}
