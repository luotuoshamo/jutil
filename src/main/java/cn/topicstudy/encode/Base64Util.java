package cn.topicstudy.encode;

import cn.topicstudy.basic.file.FileUtil;
import cn.topicstudy.basic.text.StringUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Base64Util {
    private static Base64.Encoder base64Encoder = Base64.getEncoder();
    private static Base64.Decoder base64Decoder = Base64.getDecoder();

    private Base64Util() {
    }

    /**
     * byte[] => base64String
     */
    public static String encode(byte[] byteArray) {
        if (byteArray == null || byteArray.length == 0) return null;
        return base64Encoder.encodeToString(byteArray);
    }

    /**
     * base64String => byte[]
     */
    public static byte[] decode(String base64String) {
        if (StringUtil.isBlank(base64String)) return null;
        return base64Decoder.decode(base64String);
    }

    /**
     * 编码urlString对应的文件
     */
    @Deprecated
    public static String encodeFile(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();
        InputStream is = httpURLConnection.getInputStream();
        byte[] bytes = FileUtil.inputStreamToByteArray(is);
        //File file = new File("./src/test/java/com/wjh/encode/1.png");
        // File file = new File("./src/test/java/com/wjh/encode/19.png");
        // FileOutputStream fos = new FileOutputStream(file);
        // FileUtil.copy(is, "./src/test/java/com/wjh/encode/19.png");

        BufferedInputStream bin = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(baos);
        byte[] buffer = new byte[1024];
        int len = bin.read(buffer);
        while (len != -1) {
            bout.write(buffer, 0, len);
            len = bin.read(buffer);
        }
        //刷新此输出流并强制写出所有缓冲的输出字节
        bout.flush();
        bytes = baos.toByteArray();
        return encode(bytes);
    }
}
