package com.wjh.os;

import com.sun.deploy.config.OSType;

import java.io.File;

/**
 * 磁盘（外存）
 */
public class DiskUtil {
    /**
     * 获取当前电脑中所有的磁盘名,适用于Windows
     *
     * @return windows返回磁盘名称，例如：{C,D,E,F}；
     *         其他系操作系统返回"/"
     */
    public static String[] allDisks() {
        if (!OSUtil.isWindows()) return new String[]{"/"};

        // if Windows:
        File[] files = File.listRoots();
        String[] disks = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            // file.toString() 返回 C:\
            String plateName = files[i].toString().substring(0, 1);
            disks[i] = plateName;
        }
        return disks;
    }
}
