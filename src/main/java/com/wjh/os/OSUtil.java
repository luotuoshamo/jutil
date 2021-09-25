package com.wjh.os;

import com.wjh.basic.text.StringUtil;

/**
 * 操作系统
 */
public class OSUtil {
    public static OSTypeEnum getOSType() {
        String osName = System.getProperty("os.name");
        if (StringUtil.isBlank(osName)) return OSTypeEnum.UNKNOWN;
        if (StringUtil.constainsIgnoreCase(osName, "Windows")) return OSTypeEnum.WINDOWS;
        if (StringUtil.constainsIgnoreCase(osName, "Linux") || StringUtil.constainsIgnoreCase(osName, "Centos"))
            return OSTypeEnum.LINUX;
        return OSTypeEnum.UNKNOWN;
    }

}
