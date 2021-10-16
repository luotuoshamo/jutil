package com.wjh.os;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * 内存
 */
public class MemoryUtil {
    public static long total() {
        OperatingSystemMXBean memory = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalPhysicalMemorySize = memory.getTotalPhysicalMemorySize();
        return totalPhysicalMemorySize;
    }

    public static long free() {
        OperatingSystemMXBean memory = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long freePhysicalMemorySize = memory.getFreePhysicalMemorySize();
        return freePhysicalMemorySize;
    }

    public static long used() {
        return total() - free();
    }

    public static int freePercent() {
        double percent = free() * 1.0 / total();
        percent *= 100;
        return (int) percent;
    }

    public static int usedPercent() {
        return 100 - freePercent();
    }
}
