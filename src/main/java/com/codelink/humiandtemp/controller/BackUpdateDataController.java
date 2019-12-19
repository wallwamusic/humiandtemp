package com.codelink.humiandtemp.controller;

import com.codelink.humiandtemp.bean.HumiAndTemp;
import com.codelink.humiandtemp.service.HumiAndTempServiceInf;
import com.codelink.humiandtemp.utils.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class BackUpdateDataController {
    @Autowired
    private HumiAndTempServiceInf humiAndTempServiceInf;

    @RequestMapping("/upload.action")
    public void backUploadData(HumiAndTemp humiAndTemp, HttpServletResponse response) throws IOException {
        PrintWriter out = null;
        try {
                if (Double.valueOf(humiAndTemp.getTempvalue()) > 30 || Double.valueOf(humiAndTemp.getHumivalue()) > 60) {
                    SendMailUtil.sendMail();
                }
                int i = humiAndTempServiceInf.uploadData(humiAndTemp);
                if (i >= 1) {
                    out = response.getWriter();
                    out.println("1");//1,代表上传成功，0，代表上传失败
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
            out = response.getWriter();
            out.println("0");//1,代表上传成功，0，代表上传失败
            out.flush();
            out.close();
            e.printStackTrace();
        }
    }
}
