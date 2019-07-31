package com.gao.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author gs
 * @Date created time 2019/6/11 14:44
 * @Description
 */
public class ImageUtils {

    private static int smSzie = 100;

    private static int mdSzie = 300;


    public static Map<String, String> saveImage3Size(BufferedImage image, String targetPath, String fileName, String extention, int width, int height) {
        Map<String, String> map = new HashMap<>();
        boolean w_h = width >= height ? true : false;

        String smName = null;
        String mdName = null;
        String srcName = null;
        try {
            smName = saveImageWithSize(image, targetPath, fileName, extention, w_h, smSzie);
            mdName = saveImageWithSize(image, targetPath, fileName, extention, w_h, mdSzie);
            srcName = saveImageSrc(image, targetPath, fileName, extention, w_h ? width : height);
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.put("sm", smName);
        map.put("md", mdName);
        map.put("src", srcName);

        return map;
    }


    public static String saveImageWithSize(BufferedImage image, String targetPath, String fileName, String extention, boolean w_h, int size) throws IOException {
        fileName = fileName + "_" + size + ".jpg";
        targetPath = targetPath + fileName;
        Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(image);
        if (isNotJpg(extention)) {
            image2jpg(builder);
        }
        size(builder, w_h, size);
        builder.toFile(targetPath);
        return fileName;
    }

    public static String saveImageSrc(BufferedImage image, String targetPath, String fileName, String extention, int size) throws IOException {
        fileName = fileName + "_" + size + ".jpg";
        targetPath = targetPath + fileName;
        Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(image);
        if (isNotJpg(extention)) {
            image2jpg(builder);
        }
        builder.scale(1f);
        builder.toFile(targetPath);
        return fileName;
    }

    public static void image2jpg(Thumbnails.Builder builder) {
        builder.outputFormat("jpg");
    }

    public static void size(Thumbnails.Builder builder, boolean w_h, int size) {
        if (w_h) {
            builder.width(size);
        } else {
            builder.height(size);
        }
    }

    public static boolean isNotJpg(String extention) {
        if ("jpg".equals(extention)) {
            return false;
        }
        return true;
    }

    public static boolean isImage(String extention) {
        if ("jpg".equals(extention) || "jpeg".equals(extention) || "png".equals(extention)) {
            return true;
        }
        return false;
    }
}
