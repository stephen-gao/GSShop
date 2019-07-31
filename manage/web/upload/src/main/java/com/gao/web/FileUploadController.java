package com.gao.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.utils.ImageUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Author gs
 * @Date created time 2019/6/10 19:43
 * @Description
 */
@RestController
@RequestMapping("upload")
public class FileUploadController {

    private Logger logger = LogManager.getLogger(FileUploadController.class);

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.port}")
    private String serverPort;

    @Value("${file.uploadPath}")
    private String uploadPath;

    @Value("${file.visitPath}")
    private String visitPath;


    @PostMapping("uploadone")
    public Result uploadOne(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();

        MultipartFile file = files[0];
        String fileName = file.getOriginalFilename();

        BufferedImage image = null;
        try {
            image = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image == null) {
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR, "上传图片有异常");
        }
        int width = image.getWidth();
        int height = image.getHeight();

        //文件后缀
        String extention = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

        fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String visitName = scheme + "://" + serverName + ":" + serverPort + contextPath + visitPath;

        Map<String, String> map = ImageUtils.saveImage3Size(image, uploadPath , fileName, extention, width,height);

//        //压缩存储文件 by gs 2019-05-22
//        saveImage(file, uploadPath + fileName, extention, logger);
//
//        logger.info(fileName);
//        JSONObject json = new JSONObject();
//        json.put("filePath", scheme + "://" + serverName + ":" + serverPort + contextPath + visitPath + fileName);
        map.put("sm",visitName+map.get("sm"));
        map.put("md",visitName+map.get("md"));
        map.put("src",visitName+map.get("src"));

        return ResultFactory.getDataResult(map);
    }

    private void saveImage(MultipartFile file, String targetPath, String extention, Logger logger) {
        if (".jpg".equals(extention) || ".jpeg".equals(extention)) {
            compressAndSaveImage(file, targetPath);
            logger.info("压缩并存储图片 " + file.getOriginalFilename());
        } else {
            File tagetFile = new File(targetPath);//创建文件对象
            if (!tagetFile.exists()) {//文件名不存 a在 则新建文件，并将文件复制到新建文件中
                try {
                    tagetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.transferTo(tagetFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void compressAndSaveImage(MultipartFile file, String targetPath) {
        try {
            Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.75f).toFile(targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
