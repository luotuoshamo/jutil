package com.wjh.basic.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件、文件夹工具类
 * 所有地址都用绝对地址
 */
public class FileUtil {
    public static byte[] block_1MB = new byte[1024];

    /**
     * 删除文件或文件夹
     *
     * @param path 例如：d:/tmp   d:/    d:/x.txt
     */
    public static void delete(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {//文件可直接删除
            file.delete();
        } else if (file.isDirectory()) {//空文件夹才能直接删除
            String[] subFileNames = file.list();//文件夹file中的文件、文件夹
            if (subFileNames == null) {//文件不存在或其它错误
                return;
            }
            //空文件夹可直接删除
            if (subFileNames.length == 0) {
                file.delete();
            }
            //清空文件夹中的内容
            for (String subFileName : subFileNames) {
                String absolutePath = file.getAbsolutePath();
                absolutePath = absolutePath.endsWith("/") || absolutePath.endsWith("\\") ? absolutePath : absolutePath + "/";

                String subFilePath = absolutePath + subFileName;
                delete(subFilePath);
            }
            //删除空文件夹
            file.delete();
        }
    }

    /**
     * 判断文件夹是否是空的
     *
     * @return 文件夹为空返回true
     */
    public static boolean isEmptyDir(String dirPath) throws Exception {
        File file = new File(dirPath);
        if (!file.exists()) {
            throw new Exception("文件夹【" + dirPath + "】不存在");
        }
        if (file.isFile()) {
            throw new Exception("dirPath不是文件夹");
        }
        String[] subFileNames = file.list();
        if (subFileNames == null) {
            throw new Exception("subFileNames == null");
        }
        return subFileNames.length == 0;
    }


    /**
     * 复制文件
     *
     * @param toPath 文件 将a文件的内容复制到toPath
     *               文件夹 在toPath中
     */
    public static void copyFile(String fromPath, String toPath) throws Exception {
        File fromFile = new File(fromPath);
        File toFile = new File(toPath);
        if (!fromFile.isFile()) {
            throw new Exception("【" + fromPath + "】不是文件");
        }
        if (!fromFile.exists()) {
            throw new Exception("【" + fromPath + "】不存在");
        }

        if (toFile.isFile()) {//d:/tmp/b.txt
            toFile = toFile.exists() ? toFile : new File(toFile, fromFile.getName());
            FileInputStream fileInputStream = new FileInputStream(fromFile);
            FileOutputStream fileOutputStream = new FileOutputStream(toFile);
            int readByteCount = -1;
            while ((readByteCount = fileInputStream.read(block_1MB)) != -1) {

            }
        }
    }

    /**
     * 将文件fromFilePath中的内容复制到toFilePath中
     *
     * @param fromFilePath 绝对路径 d:/a.txt
     * @param toFilePath   绝对路径 d:/b.txt
     */
    public static void copyFileToFile(String fromFilePath, String toFilePath) throws Exception {
        File fromFile = new File(fromFilePath);
        File toFile = new File(fromFilePath);
        if (!fromFile.exists()) {
            throw new Exception("【" + fromFilePath + "】不存在");
        }
        if (!fromFile.isFile()) {
            throw new Exception("【" + fromFilePath + "】不是文件");
        }
        if (!toFile.exists()) {
            throw new Exception("【" + toFilePath + "】不存在");
        }
        if (!toFile.isFile()) {
            throw new Exception("【" + toFilePath + "】不是文件");
        }
        FileInputStream fileInputStream = new FileInputStream(fromFile);
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);
        int readByte;//读到的1个byte
        while ((readByte =fileInputStream.read())!=-1) {
            System.out.println(readByte);
            fileOutputStream.write(readByte);
        }
        //fileInputStream.close();
        //fileOutputStream.close();
    }

    public static void main(String[] args) throws Exception {
       // copyFileToFile("d:/tmp/a.txt","d:/tmp/b.txt");
      String p="d:/tmp/a.txt";
      String p2="d:/tmp/b.txt";
        File file = new File(p);
        File file2 = new File(p2);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        int read = fileInputStream.read();
        fileOutputStream.write(read);
        fileOutputStream.close();
        fileInputStream.close();
        System.out.println(read);
    }
}
