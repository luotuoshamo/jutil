package com.wjh.os;

import com.wjh.basic.text.StringUtil;

/**
 * 操作系统
 */
public class OSUtil {
    public static OSTypeEnum getOSType() {
        String osName = System.getProperty("os.name");
        if (StringUtil.isBlank(osName)) return OSTypeEnum.UNKNOWN;
        if (StringUtil.containsIgnoreCase(osName, "Windows")) return OSTypeEnum.WINDOWS;
        if (StringUtil.containsIgnoreCase(osName, "Linux")
                || StringUtil.containsIgnoreCase(osName, "Centos")
                || StringUtil.containsIgnoreCase(osName, "Redhat")) {
            return OSTypeEnum.LINUX;
        }
        return OSTypeEnum.UNKNOWN;
    }

    /**
     * 当前操作系统是否是windows
     */
    public static boolean isWindows() {
        return OSTypeEnum.WINDOWS.equals(OSUtil.getOSType());
    }


    /**
     * 当前操作系统是否是Linux
     */
    public static boolean isLinux() {
        return OSTypeEnum.LINUX.equals(OSUtil.getOSType());
    }
}
