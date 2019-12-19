package com.codelink.humiandtemp.controller;

import com.alibaba.fastjson.JSONObject;
import com.codelink.humiandtemp.service.UploadService;
import com.codelink.humiandtemp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/uploadPic.action")
    //required = false --- 允许pic参数为空
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) throws Exception {
        //测试,查看上传图片的名字
        String path = uploadService.uploadPic(pic.getBytes(),pic.getOriginalFilename(),pic.getSize());
        String url = Constants.IMG_URL + path;
        JSONObject jo = new JSONObject();
        jo.put("url",url);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jo.toString());
    }

    @RequestMapping(value = "/uploadPics.action")
    @ResponseBody
    public List<String> uploadPics(@RequestParam(required = false)MultipartFile[] pics) throws IOException {
        List<String> urls = new ArrayList<>();
        for (MultipartFile pic : pics) {
            String path = uploadService.uploadPic(pic.getBytes(),pic.getOriginalFilename(),pic.getSize());
            String url = Constants.IMG_URL + path;
            urls.add(url);
        }
        return urls;
    }

    @RequestMapping(value = "/uploadFck.action")
    public void uploadPics(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        //以下操作为了获取上两个方法中的pic参数
        MultipartRequest mr = (MultipartRequest) request;
        Map<String,MultipartFile> fileMap = mr.getFileMap();
        Set<Map.Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
        for (Map.Entry<String, MultipartFile> entry : entrySet) {
            MultipartFile pic = entry.getValue();
            String path = uploadService.uploadPic(pic.getBytes(),pic.getOriginalFilename(),pic.getSize());
            String url = Constants.IMG_URL + path;
            System.out.println("图片网址:"+ url);
            JSONObject jo = new JSONObject();
            jo.put("url",url);
            jo.put("error", 0);// 没有错误
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(jo.toString());
        }
    }
}
