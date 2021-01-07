package com.wjh.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileEncoding {
    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("d:/tmp/t/f.txt"),
                        "UTF-16"
                )
        );
        bufferedWriter.append("汉字");
        bufferedWriter.append("english");
        bufferedWriter.close();
    }
}
