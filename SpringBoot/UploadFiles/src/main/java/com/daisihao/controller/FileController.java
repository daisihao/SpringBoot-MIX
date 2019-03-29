package com.daisihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileController {

    @RequestMapping("/index")
    public String index(){
        return "upload";
    }
    @RequestMapping("/indexs")
    public String indexs(){
        return "uploads";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest httpServletRequest){
        try {
            //第一步,创建文件在服务器中的存放路径
            String path = httpServletRequest.getServletContext().getRealPath("/upload");
            //第二步,创建文件夹对象
            File fileDir = new File(path);
            //第三步,判断文件夹是否存在
            if(!fileDir.exists()){
                fileDir.mkdir();
            }
            //第四步,获取上传文件名字
            String originalFilename = file.getOriginalFilename();
            //第五步,创建文件对象
            File filedes = new File(fileDir+"/"+originalFilename);
            //写入文件
            file.transferTo(filedes);
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    @ResponseBody
    public String uploadBatch(MultipartFile[] file, HttpServletRequest httpServletRequest){
        try {
            //第一步,创建文件在服务器中的存放路径
            String path = httpServletRequest.getServletContext().getRealPath("/upload");
            //第二步,创建文件夹对象
            File fileDir = new File(path);
            //第三步,判断文件夹是否存在
            if(!fileDir.exists()){
                fileDir.mkdir();
            }
            //第四步,获取上传文件名字
            for(int i=1;i<file.length;i++){
                String originalFilename = file[i].getOriginalFilename();
                //第五步,创建文件对象
                File filedes = new File(fileDir+"/"+originalFilename);
                //写入文件
                file[i].transferTo(filedes);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
