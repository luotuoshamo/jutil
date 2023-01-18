package cn.topicstudy.encode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import  cn.topicstudy.basic.text.StringUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Hashtable;

public class QRCodeUtil {
    public static BufferedImage createQRCode(String content, int width, int height) {
        if (StringUtil.isBlank(content)) return null;
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            return null;
        }

        // test
        boolean isTest = false;
        if (isTest) {
            Path path = FileSystems.getDefault().getPath("d:/tmp/a.png");
            try {
                MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return bufferedImage;
    }

    public static String getBase64QrCode(String content, int width, int height) {
        BufferedImage image = createQRCode(content, width, height);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "PNG", stream);
        } catch (IOException e) {
            return null;
        }
        String s = Base64.getEncoder().encodeToString(stream.toByteArray());
        return s;
    }
}
