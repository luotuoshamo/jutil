package cn.topicstudy.jutil.os;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MemoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void total() {
        long total = MemoryUtil.total();
        // System.out.println(total * 1.0 / 1024 / 1024 / 1024);
    }

    @Test
    public void free() {
        long free = MemoryUtil.free();
        //System.out.println(free * 1.0 / 1024 / 1024 / 1024);
    }

    @Test
    public void used() {
        long used = MemoryUtil.used();
        // System.out.println(used * 1.0 / 1024 / 1024 / 1024);
    }

    @Test
    public void freePercent() {
        int percent = MemoryUtil.freePercent();
        //System.out.println(percent);
    }
}
