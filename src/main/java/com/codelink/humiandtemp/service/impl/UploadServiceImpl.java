package com.codelink.humiandtemp.service.impl;

import com.codelink.humiandtemp.service.UploadService;
import com.codelink.humiandtemp.utils.FastDFSUtils;
import org.springframework.stereotype.Service;

@Service(value = "UploadServiceImpl")
public class UploadServiceImpl implements UploadService {
    @Override
    public String uploadPic(byte[] pic, String name, long size) {
        return FastDFSUtils.uploadPic(pic,name,size);
    }
}
