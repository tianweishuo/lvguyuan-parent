package com.lvguyuan.shop.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created with IntelliJ IDEA
 * Created By Kinsey
 * Date: 2018/5/3
 * Time: 11:14
 */
@RestController
public class UploadController {

    @Value("FILE_SERVER_URL")
    private String file_server_url;

    /**
     * 文件上传功能
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile){
        //获取文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //获取文件扩展名
        String extName = originalFilename.substring(originalFilename.indexOf(".")+1);
        try{
            //参数1：保存路径，参数2：文件名称
            File file = new File("D:"+File.separator,extName);
            //保存到一个文件中
            uploadFile.transferTo(file);
            return new Result(true,"上传成功!");
        }catch(Exception e){
            return new Result(false,"上传失败!:"+e.getMessage());
        }


    }



}
